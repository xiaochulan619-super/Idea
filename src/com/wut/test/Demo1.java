package com.wut.test;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数");
        int num1 = sc.nextInt();
        System.out.println(num1);

        System.out.println("请输入第二个整数");
        int num2 = sc.nextInt();
        System.out.println(num2);

        int res = num1 + num2;
        System.out.println("两个数的和为：" + res);

    }
}