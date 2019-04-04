package xpfei.demo.singleton;

/**
 * Description: 单例模式-饿汉式
 * <p>
 * <p>
 * 随着类的加载，对象就已经被创建
 *
 * @author xpfei
 * @date 2019/4/3
 */
public class SingletonUtil {
    private static SingletonUtil mInstance = new SingletonUtil();

    private SingletonUtil() {

    }

    public static SingletonUtil getInstance() {
        return mInstance;
    }
}
