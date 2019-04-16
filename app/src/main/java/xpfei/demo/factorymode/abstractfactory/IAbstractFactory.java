package xpfei.demo.factorymode.abstractfactory;

import android.content.Context;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/16
 */
public interface IAbstractFactory {
    IAbstract createIAbstract(Context context);
}
