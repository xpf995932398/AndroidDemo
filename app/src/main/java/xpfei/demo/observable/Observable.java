package xpfei.demo.observable;

import android.util.Log;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xpfei
 * 被观察者
 */
class Observable {
    private List<Observer> observables;

    Observable() {
        observables = new ArrayList<>();
    }

    void register(Observer observer) {
        observables.add(observer);
    }

    void unregister(Observer observer) {
        observables.remove(observer);
    }

    void addUpdate(String value) {
        for (Observer observable : observables) {
            observable.update(value);
            Method[] methods = observable.getClass().getDeclaredMethods();
            for (Method method : methods) {
                ObserverMethod observerMethod = method.getAnnotation(ObserverMethod.class);
                if (observerMethod != null) {
                    method.setAccessible(true);
                    try {
                        method.invoke(observable, value);
                        Log.d("networkEngine", "包含: " + method.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
