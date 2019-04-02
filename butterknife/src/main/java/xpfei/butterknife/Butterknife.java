package xpfei.butterknife;

import android.app.Activity;

import java.lang.reflect.Constructor;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/1
 */
public class Butterknife {
    @SuppressWarnings("unchecked")
    public static Unbinder bind(Activity activity) {
        try {
            Class<? extends Unbinder> bindClass = (Class<? extends Unbinder>) Class.forName(activity.getClass().getName() + "ViewBinding");
            Constructor<? extends Unbinder> constructor = bindClass.getDeclaredConstructor(activity.getClass());
            return constructor.newInstance(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Unbinder.EMPTY;
    }
}
