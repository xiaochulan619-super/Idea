package com.wut.test;

import java.util.Scanner;

public class Demo6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数字");
        int num2 = sc.nextInt();

        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);

        int count = 0;
        for(int i = min; i<=max;i++){
            if(i % 3 == 0 && i % 5 == 0){
                count++;

                System.out.println(i);

            }
        }

        if(count == 0) {
            System.out.println("在" + min + "到" + max + "之间没有合适的数");
        }else {
            System.out.println("在" + min + "到" + max + "之间共有" + count + "个数");

        }
    }
}
