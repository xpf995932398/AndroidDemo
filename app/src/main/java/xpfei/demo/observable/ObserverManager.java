package xpfei.demo.observable;

/**
 * Description: 观察者模式工具类
 *
 * @author xpfei
 * @date 2019/5/16
 */
class ObserverManager {
    private static volatile ObserverManager instance;
    private Observable observable;

    private ObserverManager() {
        observable = new Observable();
    }

    static ObserverManager getInstance() {
        if (instance == null) {
            synchronized (ObserverManager.class) {
                if (instance == null) {
                    instance = new ObserverManager();
                }
            }
        }
        return instance;
    }

    void register(Observer observer) {
        observable.register(observer);
    }

    void unregister(Observer observer) {
        observable.unregister(observer);
    }

    void addUpdate(String value) {
        observable.addUpdate(value);
    }
}
