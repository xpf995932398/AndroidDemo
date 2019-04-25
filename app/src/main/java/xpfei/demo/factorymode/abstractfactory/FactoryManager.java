package xpfei.demo.factorymode.abstractfactory;

/**
 * Description:
 *
 * @author xpfei
 * @date 2019/4/16
 */
public class FactoryManager {
    private FactoryManager() {
    }


    public static IFactory getFactory(Class<? extends IFactory> clazz) {
        try {
            clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return new FileFactory();
    }
}
