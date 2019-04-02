package xpfei.demo.BuildAnnotation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import xpfei.butterknife.Butterknife;
import xpfei.butterknife.Unbinder;
import xpfei.butterknife.annotations.BindView;
import xpfei.demo.R;

/**
 * Description: 编译时注解
 *
 * @author xpfei
 * @date 2019/4/1
 */
public class BuildAnnotationPageActivity extends AppCompatActivity {
    @BindView(R.id.mToolbar)
    Toolbar mToolbar;
    @BindView(R.id.tvTest)
    TextView tvTest;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildannotationpage);
        mUnbinder = Butterknife.bind(this);
        tvTest.setText("编译时注解");
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }
}
