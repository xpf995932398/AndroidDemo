package xpfei.demo.factorymode.method;

import android.content.Context;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/16
 */
public class MethodAcacheFactory implements IMethodFactory {

    @Override
    public IMethod createIMethod(Context context) {
        return new MethodAcacheInterface(context);
    }
}
