package xpfei.demo.decorator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import xpfei.demo.R;
import xpfei.demo.build.MyTitleBar;
import xpfei.demo.databinding.AvtivityDecoratorBinding;

/**
 * Description: 装饰设计模式
 *
 * @author xpfei
 * @date 2019/4/25
 */
public class DecoratorPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AvtivityDecoratorBinding binding = DataBindingUtil.setContentView(this, R.layout.avtivity_decorator);
        new MyTitleBar.Builder(this, binding.root).setTitle("装饰模式").create();
        AndroidProgrammer programmer = new AndroidProgrammer();
        AdvancedAndroidProgrammer advancedAndroidProgrammer = new AdvancedAndroidProgrammer();
        advancedAndroidProgrammer.setProgrammer(programmer);
        programmer.writeCode();
        advancedAndroidProgrammer.writeCode();
    }
}
