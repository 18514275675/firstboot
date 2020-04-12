package com.luheng.designpattern.observer;

/**
 * 观察者的具体实现
 */
public class ObserverImpl implements Observer {

    @Override
    public void updateStatus(String status) {
        System.out.println("具体观察者[ObserverImpl] 状态被修改为:[" + status + "]");
    }
}
