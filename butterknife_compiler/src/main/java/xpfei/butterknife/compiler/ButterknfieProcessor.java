package xpfei.butterknife.compiler;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import xpfei.butterknife.annotations.BindView;

/**
 * Description: 类生产器
 *
 * @author xpfei
 * @date 2019/4/1
 */
@AutoService(Processor.class)
public class ButterknfieProcessor extends AbstractProcessor {
    private Filer filer;
    private Elements mElement;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnvironment.getFiler();
        mElement = processingEnvironment.getElementUtils();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        for (Class<? extends Annotation> cla : getSupportedAnnotation()) {
            types.add(cla.getCanonicalName());
        }
        return types;
    }

    private Set<Class<? extends Annotation>> getSupportedAnnotation() {
        Set<Class<? extends Annotation>> annotations = new LinkedHashSet<>();
        annotations.add(BindView.class);
        return annotations;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        //根据对应的activity分开,将BindView进行分类
        Map<Element, List<Element>> elementMap = getElements(roundEnvironment, BindView.class);
        //生成java文件
        for (Map.Entry<Element, List<Element>> entry : elementMap.entrySet()) {
            Element element = entry.getKey();
            List<Element> list = entry.getValue();
            //创建类
            String activityName = element.getSimpleName().toString();//获取类名
            ClassName unbinderName = ClassName.get("xpfei.butterknife", "Unbinder");//需要实现的接口类
            ClassName fieldClassName = ClassName.bestGuess(activityName);//获取类的类型
            TypeSpec.Builder classBuilder = TypeSpec.classBuilder(activityName + "ViewBinding")
                    .addModifiers(Modifier.FINAL, Modifier.PUBLIC)
                    .addSuperinterface(unbinderName)//添加需要实现的接口
                    .addField(fieldClassName, "target", Modifier.PRIVATE);//添加参数

            /* 上述这段代码 主要生成：public final class XXXXViewBinding implements Unbinder 和参数：private XXXX target;*/


            //添加构造函数
            MethodSpec.Builder constructor = MethodSpec.constructorBuilder()
                    .addParameter(fieldClassName, "target");//添加构造函数入参
            constructor.addStatement("this.target=target");

            //实现接口的回调方法
            ClassName callSuper = ClassName.get("android.support.annotation", "CallSuper");
            MethodSpec.Builder unBinder = MethodSpec.methodBuilder("unbind")
                    .addAnnotation(Override.class)
                    .addAnnotation(callSuper)
                    .addModifiers(Modifier.PUBLIC);
            unBinder.addStatement("$T target = this.target", fieldClassName);
            unBinder.addStatement("if (target == null) throw new IllegalStateException(\"Bindings already cleared.\")");
            unBinder.addStatement("this.target = null");

            for (Element element1 : list) {
                //获取控件的名称
                String field = element1.getSimpleName().toString();
                //获取xpfei.butterknife包下的Utils方法
                ClassName utils = ClassName.get("xpfei.butterknife", "Utils");
                //获取使用注解BindView中的控件id
                int viewId = element1.getAnnotation(BindView.class).value();
                constructor.addStatement("target.$L=$L.findViewById(target,$L)", field, utils, viewId);
                unBinder.addStatement("target.$L = null", field);
            }


            //将创建的方法添加到类中
            classBuilder.addMethod(constructor.build());
            classBuilder.addMethod(unBinder.build());

            try {
                //获取当前当前activity所在包的名称
                String packageName = mElement.getPackageOf(element).getQualifiedName().toString();
                JavaFile.builder(packageName, classBuilder.build())
                        .addFileComment("Butterknfie自动生成的类")//添加生成注释
                        .build().writeTo(filer);
            } catch (IOException e) {
                System.out.println("报错了~");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 获取类中所有包含class的集合
     *
     * @param roundEnvironment RoundEnvironment
     * @param var1             注解类
     * @return Set
     */
    private Map<Element, List<Element>> getElements(RoundEnvironment roundEnvironment, Class<? extends Annotation> var1) {
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(var1);
        Map<Element, List<Element>> elementMap = new LinkedHashMap<>();
        //根据对应的activity分开,将BindView进行分类
        for (Element element : elements) {
            Element enclosingElement = element.getEnclosingElement();//获取对应的activity类
            List<Element> list = elementMap.get(enclosingElement);
            if (list == null) {
                list = new ArrayList<>();
                elementMap.put(enclosingElement, list);
            }
            list.add(element);
        }
        return elementMap;
    }
}
