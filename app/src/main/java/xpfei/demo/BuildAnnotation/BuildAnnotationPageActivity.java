package xpfei.demo.BuildAnnotation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import xpfei.butterknife.annotations.BindView;
import xpfei.demo.R;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/1
 */
public class BuildAnnotationPageActivity extends AppCompatActivity {
    @BindView(R.id.tvTest)
    TextView tvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
