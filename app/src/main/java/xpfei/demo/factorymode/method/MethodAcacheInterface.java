package xpfei.demo.factorymode.method;

import android.content.Context;

import xpfei.demo.Acache;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/16
 */
public class MethodAcacheInterface implements IMethod {
    private Context context;

    public MethodAcacheInterface(Context context) {
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
