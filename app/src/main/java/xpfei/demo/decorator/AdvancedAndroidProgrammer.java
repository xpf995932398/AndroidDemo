package xpfei.demo.decorator;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/26
 */
public class AdvancedAndroidProgrammer extends AbstractProgrammer {
    private void writeHtml() {
        System.out.println("我是高级安卓工程师，我不仅会开发App，还会开发网站");
    }

    @Override
    public void writeCode() {
        super.writeCode();
        writeHtml();
    }
}
