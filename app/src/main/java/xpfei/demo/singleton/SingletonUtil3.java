package xpfei.demo.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 单例模式-容器管理(参考获取系统服务的代码)
 *
 * @author xpfei
 */
public class SingletonUtil3 {
    private final static String name = "SingletonUtil3";
    private static Map<String, SingletonUtil3> mSingletonMap = new HashMap<>();


    static {
        mSingletonMap.put("", new SingletonUtil3());
    }

    private SingletonUtil3() {

    }

    public static SingletonUtil3 getInstance() {
        return mSingletonMap.get(name);
    }
}
