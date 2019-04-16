package xpfei.demo.factorymode;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import xpfei.demo.R;
import xpfei.demo.build.MyTitleBar;
import xpfei.demo.databinding.AvtivityFactorymodeBinding;
import xpfei.demo.factorymode.abstractfactory.FactoryManager;
import xpfei.demo.factorymode.method.MethodAcacheFactory;
import xpfei.demo.factorymode.simple.SimpleFactory;

import static xpfei.demo.factorymode.simple.SimpleFactory.SimpleType.Acache;

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
        //简单工厂模式
        SimpleFactory.createSimpleFactory(Acache, this).save("", "");
        SimpleFactory.createSimpleFactory(Acache, this).getValue("");
        //工厂方法模式
        new MethodAcacheFactory().createIMethod(this).save("", "");
        new MethodAcacheFactory().createIMethod(this).getValue("");
        //抽象工厂模式
        FactoryManager.getInstance().getAcache(this).save("", "");
        FactoryManager.getInstance().getAcache(this).getValue("");
    }
}
