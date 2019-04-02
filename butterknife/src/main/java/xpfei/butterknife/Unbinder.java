package xpfei.butterknife;

import android.support.annotation.UiThread;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/1
 */
public interface Unbinder {
    @UiThread
    void unbind();

    Unbinder EMPTY = new Unbinder() {
        @Override
        public void unbind() {

        }
    };
}
