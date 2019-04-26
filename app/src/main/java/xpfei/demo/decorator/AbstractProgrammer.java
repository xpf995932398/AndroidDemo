package xpfei.demo.decorator;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/4/26
 */
public class AbstractProgrammer implements Programmer {
    protected Programmer programmer;

    public void setProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }

    @Override
    public void writeCode() {
        programmer.writeCode();
    }
}
