package xpfei.demo.factorymode.method;

public class SpFactory implements IFactory {


    @Override
    public IProduct createProduct() {
        return new SpProduct();
    }
}
