package xpfei.demo.observable;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import xpfei.demo.R;
import xpfei.demo.build.MyTitleBar;
import xpfei.demo.databinding.ActivityObserverchildBinding;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/5/16
 */
public class ObserverChildActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityObserverchildBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observerchild);
        new MyTitleBar.Builder(this, binding.root).setTitle("观察者模式").create();
        binding.btnStart.setOnClickListener(v -> {
            ObserverManager.getInstance().addUpdate(1 + "");
            finish();
        });
        binding.btnUpdate.setOnClickListener(v -> {
            ObserverManager.getInstance().addUpdate("ObserverChildActivity");
            Log.d("networkEngine", "更新值：ObserverChildActivity");
            finish();
        });
    }
}
