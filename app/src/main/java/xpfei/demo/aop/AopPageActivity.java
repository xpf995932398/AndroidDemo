package xpfei.demo.aop;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import xpfei.demo.R;
import xpfei.demo.databinding.ActivityAoppageBinding;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/3/21
 */
public class AopPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAoppageBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_aoppage);
        binding.mToolbar.setNavigationOnClickListener(v -> finish());
        binding.btnAop.setOnClickListener(v -> aopClick());
    }

    @check
    public void aopClick() {
        System.out.println("用户有权限，可以随意删除~");
    }
}
