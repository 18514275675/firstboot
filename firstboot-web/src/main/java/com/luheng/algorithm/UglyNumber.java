package com.luheng.algorithm;

import java.util.ArrayList;

/**
 *        题目:求第n个丑数
 *        思路:
 *         1.按顺序将丑数保存在数组中，然后求下一个丑数；
 *         2.下一个丑数是由数组中某个丑数A * 2，B * 3，C * 5中的最小值得来的。
 *         3.按照题目规定，第一个丑数是1，存入数组中        list:[1];
 *         4.第二个丑数为1*2，1*3，1*5三个中的最小值2      list:[1,2];
 *         5.第三个丑数为2*2，1*3，1*5三个中的最小值3      list:[1,2,3];
 *         6.第四个丑数为2*2，2*3，1*5三个中的最小值4      list:[1,2,3,4];
 *         7.第五个丑数为3*2，2*3，1*5三个中的最小值5      list:[1,2,3,4,5];
 *         8.第六个丑数为3*2，2*3，2*5三个中的最小值6      list:[1,2,3,4,5,6];
 *         9.第七个丑数为4*2，3*3，2*5三个中的最小值8      list:[1,2,3,4,5,6,8];
 *        10.第八个丑数为5*2，3*3，2*5三个中的最小值9      list:[1,2,3,4,5,6,8,9];
 *        11.第九个丑数为5*2，4*3，2*5三个中的最小值10     list:[1,2,3,4,5,6,8,9,10];
 *        12.第十个丑数为6*2，4*3，3*5三个中的最小值12     list:[1,2,3,4,5,6,8,9,10,12];
 *        .......n
 */
public class UglyNumber {
    public static int GetUglyNumber_Solution(int n) {
        if(n<=0) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        while (list.size()<n){//循环index-1次,当list的大小小于所求的第n个元素的序列的时候
            int t = Math.min(list.get(i)*2,Math.min(list.get(j)*3,list.get(k)*5)); //找出三个数里面的最小值
            System.out.println("list(i):"+list.get(i)+"    list(j):"+list.get(j)+"    list(k):"+list.get(k));
            list.add(t);
            if(list.get(i)*2==t) i++;
            if(list.get(j)*3==t) j++;
            if(list.get(k)*5==t) k++;
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        int i = GetUglyNumber_Solution(10);
        System.out.println(i);
    }
}
