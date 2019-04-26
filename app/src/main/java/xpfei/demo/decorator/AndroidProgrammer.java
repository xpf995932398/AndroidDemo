package xpfei.demo.decorator;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/26
 */
public class AndroidProgrammer implements Programmer {
    @Override
    public void writeCode() {
        System.out.println("我是初级安卓工程师，我会开发app");
    }
}
