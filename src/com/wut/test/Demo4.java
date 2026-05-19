package com.wut.test;

import java.util.Scanner;

public class Demo4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入总秒数");
        int second = sc.nextInt();

        int hour = second / 3600;
        System.out.println("小时数：" + hour);

        int min = (second % 3600) / 60;
        System.out.println("分钟数：" + min);

        int seconds = second % 60;
        System.out.println("秒数：" + seconds);
    }
}
