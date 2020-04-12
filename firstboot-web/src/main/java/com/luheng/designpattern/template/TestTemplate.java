package com.luheng.designpattern.template;

public class TestTemplate {
    public static void main(String[] args) {
        // 创建模板1的具体实现类
        Template templateImpl_1 = new TemplateImpl_1();
        // 调用定义好的执行模板方法的函数
        templateImpl_1.excuteTemplateMethod();
        System.out.println("========================");
        // 创建模板2的具体实现类
        Template templateImpl_2 = new TemplateImpl_2();
        // 调用定义好的执行模板方法的函数
        templateImpl_2.excuteTemplateMethod();
    }
}
