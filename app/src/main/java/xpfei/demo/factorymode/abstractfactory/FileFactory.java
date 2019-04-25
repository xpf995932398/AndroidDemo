package xpfei.demo.factorymode.abstractfactory;

public class FileFactory implements IFactory {
    @Override
    public IProductA createProductA() {
        return new FileAProduct();
    }

    @Override
    public IProductB createProductB() {
        return new FileBProduct();
    }
}
