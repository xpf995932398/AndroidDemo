package xpfei.demo.annotation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import xpfei.demo.R;


/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/3/27
 */
public class AnnotationPageActivity extends AppCompatActivity {
    @FindViewById(R.id.tv)
    private TextView tv;
    @FindViewById(R.id.mToolbar)
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotationpage);
        ViewUtil.initView(this);
        mToolbar.setNavigationOnClickListener(v -> finish());
        tv.setText("注解来的");
    }
}
