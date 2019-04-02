package xpfei.demo.reflection;

import android.text.TextUtils;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/3/27
 */
public class TestDemo {
    private String name;

    private TestDemo(String name) {
        this.name = name;
    }

    private void setName(String value) {
        this.name = value;
    }

    public void LogName() {
        if (TextUtils.isEmpty(name)) {
            name = "不知道从哪里来~";
        }
        System.out.println(name);
    }
}
