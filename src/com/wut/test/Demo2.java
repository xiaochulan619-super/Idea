package com.wut.test;

import java.util.Scanner;

public class Demo2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数字");
        int num2 = sc.nextInt();
        System.out.println("请输入运算符");
        char operator = sc.next().charAt(0);

        int res = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
        System.out.println("运算后的结果是" + res);
    }

}
