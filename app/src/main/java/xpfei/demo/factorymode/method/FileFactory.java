package xpfei.demo.factorymode.method;

public class FileFactory implements IFactory {


    @Override
    public IProduct createProduct() {
        return new FileProduct();
    }
}
