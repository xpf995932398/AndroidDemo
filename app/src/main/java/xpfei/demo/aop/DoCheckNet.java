package xpfei.demo.aop;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Description: TODO
 *
 * @author xpfei
 * @date 2019/3/21
 */
@Aspect
public class DoCheckNet {

    @Pointcut("execution(@xpfei.demo.aop.check * * (..))")
    public void checkBehavior() {
        Log.d("demo", "checkNetBehavior");
    }

    @Around("checkBehavior()")
    public Object check(ProceedingJoinPoint point) throws Throwable {
        System.out.println("用户来申请权限了。。。");
        MethodSignature signature = (MethodSignature) point.getSignature();
        check checkNet = signature.getMethod().getAnnotation(check.class);
        if (checkNet != null) {
            Context context = getContext(point.getThis());
            if (context != null) {
                if (CheckNetUtil.check(context)) {
                    return point.proceed();
                }
            }
        }
        System.out.println("用户没权限，先申请权限吧~");
        return null;
    }

    private Context getContext(Object o) {
        if (o instanceof Activity) {
            return (Activity) o;
        } else if (o instanceof Fragment) {
            return ((Fragment) o).getContext();
        } else if (o instanceof View) {
            return ((View) o).getContext();
        }
        return null;
    }
}
