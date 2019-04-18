package xpfei.demo.factorymode.method;

public class MeFactoryManager {
    private MeFactoryManager() {
    }


    public static IFactory getFactory(Class<? extends IFactory> clazz) {
        try {
            clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return new SpFactory();
    }
}
