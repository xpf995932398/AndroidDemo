package xpfei.demo.singleton;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import xpfei.demo.R;
import xpfei.demo.databinding.ActivitySingletopageBinding;

/**
 * Description: TODO
 * 通常套路：
 * 1.构造函数私有，防止外部调用
 * 2.内部必须提供静态的方法让外部调用
 *
 * @author xpfei
 * @date 2019/4/3
 */
public class SingletonPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySingletopageBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_singletopage);
        binding.mToolbar.setNavigationOnClickListener(v -> finish());
    }

    /*  演示volatile关键字的案例，可以删除volatile和加上volatile 跑一下 看看结果  */
    public static void main(String args[]) {
        Test test = new Test();
        new Thread(test).start();
        while (true) {
            if (test.isFlag) {
                System.out.println("\n终于结束了~~");
                break;
            }
        }
    }

    private static class Test implements Runnable {
        private volatile boolean isFlag = false;

        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isFlag = true;
            System.out.println("isFlag =" + isFlag());
        }

        boolean isFlag() {
            return isFlag;
        }
    }
}
