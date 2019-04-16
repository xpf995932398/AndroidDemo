package xpfei.demo.factorymode.abstractfactory;

import android.content.Context;

import xpfei.demo.Acache;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/16
 */
public class AbstractAcacheInterface implements IAbstract {
    private Context context;

    public AbstractAcacheInterface(Context context) {
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
