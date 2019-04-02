package xpfei.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/3/27
 */
//位置，即放在哪里 常用的有FIELD（属性） TYPE（类） METHOD（方法）
@Target(ElementType.FIELD)
//时间，即在什么时候去执行   SOURCE     CLASS（编译时）  RUNTIME（运行时）
@Retention(RetentionPolicy.RUNTIME)
public @interface FindViewById {
    int value();
}
