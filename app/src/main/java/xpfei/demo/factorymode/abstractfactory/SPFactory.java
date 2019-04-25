package xpfei.demo.factorymode.abstractfactory;

public class SPFactory implements IFactory {
    @Override
    public IProductA createProductA() {
        return new SpAProduct();
    }

    @Override
    public IProductB createProductB() {
        return new SpBProduct();
    }
}
