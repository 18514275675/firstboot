package com.luheng.designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 被观察者的具体实现:
 *                  提供所有观察者的集合
 *                  实现注册观察者到集合中的方法
 *                  实现从集合中移除观察者的方法
 *                  实现向所有观察者推送消息的方法(主题状态改变,通知所有观察者)
 */
public class SubJectImpl implements Subject {

    private  List<Observer> observeRegistry = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer o) {
        observeRegistry.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observeRegistry.remove(o);
    }

    @Override
    public void notifyObservers() {
        String status = "stop";
        observeRegistry.forEach(observer -> {
            observer.updateStatus(status);
        });
    }
}
