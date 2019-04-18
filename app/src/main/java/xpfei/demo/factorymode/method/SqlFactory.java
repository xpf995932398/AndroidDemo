package xpfei.demo.factorymode.method;

public class SqlFactory implements IFactory {


    @Override
    public IProduct createProduct() {
        return new SqlProduct();
    }
}
