package xpfei.demo.factorymode.simple;

import android.content.Context;

/**
 * Description: 简单工厂模式-获取对象
 *
 * @author xpfei
 * @date 2019/4/16
 */
public class SimpleFactory {
    public enum SimpleType {
        Acache
    }

    public static ISimple createSimpleFactory(SimpleType type, Context context) {
        switch (type) {
            case Acache:
                return new SimpleAcacheInterface(context);
            default:
                return new SimpleAcacheInterface(context);
        }
    }
}
