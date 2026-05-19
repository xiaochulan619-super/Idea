package com.wut.test;

import java.util.Random;
import java.util.Scanner;

public class Demo11 {
    public static void main(String args[]) {

        Random random = new Random();
        int num = random.nextInt(1,101);

        while(true){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要猜的数字：");
        int guessNum = sc.nextInt();

        if(guessNum > num) {
            System.out.println("你猜的数字太大了");
        }
        else if(guessNum < num){
            System.out.println("你猜的数字太小了");
        }else{
            System.out.println("恭喜你猜对了");
            break;
        }

    }
        }

}
