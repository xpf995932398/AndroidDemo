package xpfei.demo.factorymode.abstractfactory;

import android.content.Context;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/16
 */
public class FactoryManager {
    private static volatile FactoryManager manager;

    private FactoryManager() {

    }

    public static FactoryManager getInstance() {
        if (manager == null) {
            synchronized (FactoryManager.class) {
                if (manager == null) {
                    manager = new FactoryManager();
                }
            }
        }
        return manager;
    }

    public IAbstract getAcache(Context context) {
        return new AbstractAcacheFactory().createIAbstract(context);
    }

    public IAbstract getDefult(Context context) {
        return new AbstractAcacheFactory().createIAbstract(context);
    }
}
