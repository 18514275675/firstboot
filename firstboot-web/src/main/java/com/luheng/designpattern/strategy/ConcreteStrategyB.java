package com.luheng.designpattern.strategy;

/**
 * 策略具体算法实现B
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("策略算法 B 的实现");
    }
}
