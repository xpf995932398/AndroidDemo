package xpfei.demo.singleton;

/**
 * Description: 单例模式-静态内部类
 *
 * @author xpfei
 */
public class SingletonUtil2 {
    private SingletonUtil2() {

    }

    public static SingletonUtil2 getInstance() {
        return SingletonUtil1Holder.mInstance;
    }

    public static class SingletonUtil1Holder {
        static volatile SingletonUtil2 mInstance = new SingletonUtil2();
    }

}
