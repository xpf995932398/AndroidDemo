package xpfei.demo.annotation;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/3/27
 */
class ViewUtil {
    static void initView(Activity activity) {
        //获取activity中所有的属性
        Field[] fields = activity.getClass().getDeclaredFields();
        for (Field field : fields) {
            //将获取到的属性进行过滤
            FindViewById findViewById = field.getAnnotation(FindViewById.class);
            if (findViewById != null) {
                View view = activity.findViewById(findViewById.value());
                try {
                    field.setAccessible(true);//赋予权限
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
