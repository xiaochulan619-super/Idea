package com.wut.test;

import java.util.Scanner;

public class Demo8 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字");

        int num = sc.nextInt();
    // 计算前n项的和 S(n) = 1 - 2 + 3 - .....
        int sum = 0;
        for(int i = 1;i <= num;i++){
    // 判断i是奇数还是偶数
            if(i % 2 == 0){
                sum -= i;
            }else{
                sum += i;
            }
        }
        System.out.println(sum);
    }

}
