package xpfei.demo.factorymode.abstractfactory;

public class SqlFactory implements IFactory {
    @Override
    public IProductA createProductA() {
        return new SqlAProduct();
    }

    @Override
    public IProductB createProductB() {
        return new SqlBProduct();
    }
}
