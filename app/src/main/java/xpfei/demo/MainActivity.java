package xpfei.demo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xpfei.demo.BuildAnnotation.BuildAnnotationPageActivity;
import xpfei.demo.annotation.AnnotationPageActivity;
import xpfei.demo.aop.AopPageActivity;
import xpfei.demo.databinding.ActivityMainBinding;
import xpfei.demo.reflection.ReflectionPageActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setOnHomeClickListener(v -> {
            switch (v.getId()) {
                case R.id.btnAop:
                    startActivity(new Intent(this, AopPageActivity.class));
                    break;
                case R.id.btnReflection:
                    startActivity(new Intent(this, ReflectionPageActivity.class));
                    break;
                case R.id.btnAnnotation:
                    startActivity(new Intent(this, AnnotationPageActivity.class));
                    break;
                case R.id.btnBuildAnnotation:
                    startActivity(new Intent(this, BuildAnnotationPageActivity.class));
                    break;
                default:
            }
        });
    }
}
