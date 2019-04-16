package xpfei.demo.factorymode.simple;

import android.content.Context;

import xpfei.demo.Acache;

/**
 * Description: 简单工厂模式-实现类
 *
 * @author xpfei
 * @date 2019/4/16
 */
public class SimpleAcacheInterface implements ISimple {
    private Context context;

    SimpleAcacheInterface(Context context) {
        this.context = context;
    }

    @Override
    public void save(String key, String value) {
        Acache.get(context).put(key, value);
    }

    @Override
    public String getValue(String key) {
        return Acache.get(context).getAsString(key);
    }
}
