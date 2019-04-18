package xpfei.demo.factorymode.simple;

/**
 * @author xpfei
 * @date 2019/4/16
 */
public class SimpleFactory {
    public enum SimpleType {
        SQL, FILE, SP
    }

    public static IProduct createSimpleFactory(SimpleType type) {
        switch (type) {
            case SQL:
                return new SqlProduct();
            case FILE:
                return new FileProduct();
            case SP:
                return new SpProduct();
            default:
                return new SpProduct();
        }
    }
}
