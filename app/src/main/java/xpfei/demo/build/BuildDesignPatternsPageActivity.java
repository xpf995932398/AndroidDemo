package xpfei.demo.build;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import xpfei.demo.R;
import xpfei.demo.databinding.ActivityBuilddesignpatternsBinding;

/**
 * Description: Build设计模式
 * 又称建造者模式，将构建过程和表示过程进行分离，
 * 让（参数）构建过程变得更加的简单和直观。
 * 使用场景：对象构建过程相对来说比较复杂的情况下（参数比较多的情况）
 *
 * @author xpfei
 * @date 2019/4/10
 */

public class BuildDesignPatternsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBuilddesignpatternsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_builddesignpatterns);
        new MyTitleBar.Builder(this, binding.root)
                .setTitle("Builder设计模式")
                .setRightShow(true)
                .setOnRightClickListener(v -> Toast.makeText(this, "温馨提示", Toast.LENGTH_SHORT).show())
                .create();
    }
}
