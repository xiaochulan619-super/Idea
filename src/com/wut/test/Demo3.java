package com.wut.test;

import java.util.Scanner;

public class Demo3 {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入一个三位整数");
        int num = sc.nextInt();

        int single = num % 10;
        System.out.println("它的个位数是："+ single);

        int ten = num / 10 % 10;
        System.out.println("它的十位数是：" + ten);

        int hund =  num / 100;
        System.out.println("它的百位数是：" + hund);


    }
}
