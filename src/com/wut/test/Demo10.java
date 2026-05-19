package com.wut.test;

import java.util.Scanner;

public class Demo10 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int hurt = 0;
        while(true){
            System.out.println("请输入收到的伤害");
            hurt = sc.nextInt();

            if(hurt > 0){
                break;
            }else{
                System.out.println("输入的伤害值有误");
            }

        }

        int hp = 200;

        hp = hp- hurt;

        if(hp <= 0){
            hp = 1;
        }

        int health = 0;
        while(true){
            System.out.println("请输入治疗量");
            health = sc.nextInt();
            if(health >= 0){
                break;
            }else{
                System.out.println("输入的治疗值有误");
            }
        }

        hp = hp + health;

        System.out.println("最后的血量是：" + hp);

    }

}
