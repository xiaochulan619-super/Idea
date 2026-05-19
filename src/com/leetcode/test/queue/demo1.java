package com.leetcode.test.queue;

public class demo1 {
    
    public static int countStudents(int[] students, int[] sandwiches) {
        // 统计喜欢每种三明治的学生数量
        int count0 = 0;  // 喜欢圆形三明治(0)的学生数
        int count1 = 0;  // 喜欢方形三明治(1)的学生数
        
        for (int student : students) {
            if (student == 0) {
                count0++;
            } else {
                count1++;
            }
        }
        
        // 遍历三明治栈
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                // 当前是圆形三明治
                if (count0 > 0) {
                    count0--;  // 有学生喜欢，拿走一个
                } else {
                    break;  // 没有学生喜欢，停止
                }
            } else {
                // 当前是方形三明治
                if (count1 > 0) {
                    count1--;  // 有学生喜欢，拿走一个
                } else {
                    break;  // 没有学生喜欢，停止
                }
            }
        }
        
        // 返回无法吃午餐的学生数量
        return count0 + count1;
    }
    
    public static void main(String[] args) {
        // 测试示例1
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        System.out.println("示例1输出: " + countStudents(students1, sandwiches1));
        
        // 测试示例2
        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
        System.out.println("示例2输出: " + countStudents(students2, sandwiches2));
    }
}
