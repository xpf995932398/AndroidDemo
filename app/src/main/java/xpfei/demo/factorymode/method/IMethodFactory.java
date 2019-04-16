package xpfei.demo.factorymode.method;

import android.content.Context;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/16
 */
public interface IMethodFactory {
    IMethod createIMethod(Context context);
}
