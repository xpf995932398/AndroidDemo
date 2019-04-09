package xpfei.demo.singleton;

/**
 * Description: 单例模式-懒汉式
 * <p>
 * <p>
 * 只有在被使用的时候才会创建对象，可能更加高效
 * <p>
 * <p>
 * 存在问题：多线程并发，即多线程操作这个类时，还是会创建多个实例
 *
 * @author xpfei
 */
public class SingletonUtil1 {

    /**
     * volatile:1 防止重排序
     * 2 线程可见性-某个线程修改了公用对象，短时间内，另一个线程肯能是不可见，由于没个线程都有自己的
     * 工作区
     */
    private static volatile SingletonUtil1 mInstance;

    private SingletonUtil1() {

    }

    public static SingletonUtil1 getInstance() {
        if (mInstance == null) {
            mInstance = new SingletonUtil1();
        }
        return mInstance;
    }

    /*
     * 为了解决多线程操作创建多个对象，加上synchronized同步锁
     * 问题：避免了多线程操作创建多个对象，但是会出现效率的问题，每次操作时，
     * 都需要经过同步锁判断
     */
//    public static synchronized SingletonUtil1 getInstance() {
//        if (mInstance == null) {
//            mInstance = new SingletonUtil1();
//        }
//        return mInstance;
//    }

    /*
     *即保证了线程安全，也提高了效率
     */
//    public static SingletonUtil1 getInstance() {
//        if (mInstance == null) {
//            synchronized (SingletonUtil1.class) {
//                if (mInstance == null) {
//                    mInstance = new SingletonUtil1();
//                }
//            }
//        }
//        return mInstance;
//    }
}
