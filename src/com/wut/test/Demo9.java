package com.wut.test;

public class Demo9 {
    public static void main(String args[]){
        // 定义单位纸张的厚度
        double paper = 0.1;
        // 定义山的高度
        double height = 8848860;
        // 定义折叠次数
        int count = 0;

        while(paper < height){
             paper *= 2;
             count++;
        }

        System.out.println(count);
    }

}
