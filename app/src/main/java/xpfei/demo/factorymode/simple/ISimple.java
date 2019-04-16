package xpfei.demo.factorymode.simple;

/**
 * Description: 简单工厂模式-接口类
 *
 * @author xpfei
 * @date 2019/4/16
 */
public interface ISimple {
    void save(String key, String value);

    String getValue(String key);
}
