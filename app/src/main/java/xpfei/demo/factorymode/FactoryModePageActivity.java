package xpfei.demo.factorymode;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import xpfei.demo.R;
import xpfei.demo.build.MyTitleBar;
import xpfei.demo.databinding.AvtivityFactorymodeBinding;
import xpfei.demo.factorymode.abstractfactory.FileFactory;
import xpfei.demo.factorymode.abstractfactory.SPFactory;
import xpfei.demo.factorymode.abstractfactory.SqlFactory;
import xpfei.demo.factorymode.abstractfactory.FactoryManager;
import xpfei.demo.factorymode.method.MeFactoryManager;
import xpfei.demo.factorymode.method.SpFactory;
import xpfei.demo.factorymode.simple.SimpleFactory;

/**
 * Description: 工厂模式
 * 定义一个创建对象的接口，让子类决定实例化哪个类，
 * 而对象的创建统一交由工厂去生成，有良好的封装性，
 * 既做到了解耦也保证了最少知识原则
 *
 * @author xpfei
 * @date 2019/4/11
 */
public class FactoryModePageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AvtivityFactorymodeBinding binding = DataBindingUtil.setContentView(this, R.layout.avtivity_factorymode);
        new MyTitleBar.Builder(this, binding.root).setTitle("工厂模式").create();

        /*
         *简单工厂模式:一个抽象产品类，可以派生出多个具体产品类。
         *             一个具体工厂类，通过往此工厂的static方法中传入不同参数，
         *             产出不同的具体产品类实例
         */
        SimpleFactory.createSimpleFactory(SimpleFactory.SimpleType.FILE).add();
        SimpleFactory.createSimpleFactory(SimpleFactory.SimpleType.SQL).add();
        SimpleFactory.createSimpleFactory(SimpleFactory.SimpleType.SP).add();
        /*
         * 工厂方法模式:一个抽象产品类，可以派生出多个具体产品类。
         *              一个抽象工厂类，可以派生出多个具体工厂类。
         *              每个具体工厂类只能创建一个具体产品类的实例
         */
        MeFactoryManager.getFactory(xpfei.demo.factorymode.method.FileFactory.class).createProduct().add();
        MeFactoryManager.getFactory(SpFactory.class).createProduct().add();
        MeFactoryManager.getFactory(xpfei.demo.factorymode.method.SqlFactory.class).createProduct().add();

        /*
         *抽象工厂模式:多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。
         *             一个抽象工厂类，可以派生出多个具体工厂类。
         *             每个具体工厂类可以创建多个具体产品类的实例
         */
        FactoryManager.getFactory(FileFactory.class).createProductA().add();
        FactoryManager.getFactory(FileFactory.class).createProductB().update();
        FactoryManager.getFactory(SPFactory.class).createProductA().del();
        FactoryManager.getFactory(SPFactory.class).createProductB().get();
        FactoryManager.getFactory(SqlFactory.class).createProductA().del();
        FactoryManager.getFactory(SqlFactory.class).createProductB().get();
    }
}
