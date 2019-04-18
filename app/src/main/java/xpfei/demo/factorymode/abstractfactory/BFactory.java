package xpfei.demo.factorymode.abstractfactory;

public class BFactory implements IFactory {
    @Override
    public IProductA createProductA() {
        return new SqlAProduct();
    }

    @Override
    public IProductB createProductB() {
        return new SqlBProduct();
    }
}
