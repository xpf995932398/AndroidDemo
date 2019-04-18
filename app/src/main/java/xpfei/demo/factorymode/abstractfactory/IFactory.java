package xpfei.demo.factorymode.abstractfactory;

public interface IFactory {
    IProductA createProductA();

    IProductB createProductB();
}
