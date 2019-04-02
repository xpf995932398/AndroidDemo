package xpfei.butterknife;

import android.app.Activity;
import android.view.View;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/1
 */
public class Utils {
    public static <T extends View> T findViewById(Activity activity, int id) {
        return activity.findViewById(id);
    }
}
