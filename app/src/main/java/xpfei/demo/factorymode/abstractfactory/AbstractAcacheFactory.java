package xpfei.demo.factorymode.abstractfactory;

import android.content.Context;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/16
 */
public class AbstractAcacheFactory implements IAbstractFactory {
    @Override
    public IAbstract createIAbstract(Context context) {
        return new AbstractAcacheInterface(context);
    }
}
