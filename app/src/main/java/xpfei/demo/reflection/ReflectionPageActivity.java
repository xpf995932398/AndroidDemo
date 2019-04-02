package xpfei.demo.reflection;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import xpfei.demo.R;
import xpfei.demo.databinding.ActivityReflectionpageBinding;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/3/27
 */
public class ReflectionPageActivity extends AppCompatActivity {
    private TestDemo demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityReflectionpageBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_reflectionpage);
        binding.mToolbar.setNavigationOnClickListener(v -> finish());
        binding.setOnMyClickListener(v -> {
            switch (v.getId()) {
                case R.id.btnObject:
                    System.out.println("btnObject");
                    try {
                        Constructor constructor = TestDemo.class.getDeclaredConstructor(String.class);
                        constructor.setAccessible(true);
                        demo = (TestDemo) constructor.newInstance("获取构造函数");
                        demo.LogName();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.btnMethod:
                    if (demo == null) {
                        Toast.makeText(this, "请先获取对象", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    System.out.println("btnMethod");
                    try {
                        Method method = TestDemo.class.getDeclaredMethod("setName", String.class);
                        method.setAccessible(true);
                        method.invoke(demo, "获取方法");
                        demo.LogName();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.btnField:
                    if (demo == null) {
                        Toast.makeText(this, "请先获取对象", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    System.out.println("btnField");
                    try {
                        Field field = TestDemo.class.getDeclaredField("name");
                        field.setAccessible(true);
                        field.set(demo, "获取属性");
                        String name = (String) field.get(demo);
                        System.out.println(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
//注：getDeclaredConstructor、getDeclaredMethod、getDeclaredField均有对应的getConstructor
// 、getMethod、getField，区别在于前者是获取所有的Constructor、Method、Field，后者仅获取公共的即public
        });
    }
}
