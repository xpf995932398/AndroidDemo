package xpfei.demo.observable;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import xpfei.demo.R;
import xpfei.demo.build.MyTitleBar;
import xpfei.demo.databinding.ActivityObservermainBinding;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/5/16
 */
public class ObserverMainActivity extends AppCompatActivity implements Observer {
    private String name = "Main";
    private ActivityObservermainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_observermain);
        new MyTitleBar.Builder(this, binding.root).setTitle("观察者模式").create();
        binding.tvShow.setText(name);
        binding.btnStart.setOnClickListener(v -> startActivity(new Intent(this, ObserverChildActivity.class)));
        ObserverManager.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObserverManager.getInstance().unregister(this);
    }

    @Override
    public void update(String obj) {
        Log.d("networkEngine", "ObserverMainActivity更新结果：" + obj);
        name = obj;
        binding.tvShow.setText(name);
    }

    @ObserverMethod
    public void demo(String obj) {
        name = obj;
        binding.tvShow.setText(name);
    }
}
