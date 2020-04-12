package com.luheng.controller;

import java.util.function.Function;

public class Java8Function {

    /**
     * java8,将函数作为参数传递
     */
    public void testMethod(){
        //1-将getName()方法,作为参数传递
        String s = method(Java8Function::getName,"aaa");
    }

    /**
     * 2-通过java提供的function接口类型来解释,泛型为<入参类型,返回值类型>
     */
    public String method(Function<String,String> fun, String prarm){
        //3-执行传递进来的函数
        String apply = fun.apply(prarm);
        System.out.println(apply);
        return apply;
    }


    public static String getName(String b){
        return "bababa";
    }
}
