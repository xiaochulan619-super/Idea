package com.leetcode.test.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class demo4 {
    /**
     * 找出数组中重复的数字和丢失的数字
     *
     * @param nums 发生错误后的数组
     * @return 长度为2的数组，第一个元素是重复的数字，第二个元素是丢失的数字
     */
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];

        for (int num : nums) {
            count[num]++;
        }

        int duplicate = -1;
        int missing = -1;

        for (int i = 1; i <= n; i++) {
            if (count[i] == 2) {
                duplicate = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }

    /**
     * 主方法，通过键盘录入方式获取数据并找出重复和丢失的数字
     *
     * @param args 命令行参数数组
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入数组长度: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.print("请输入" + n + "个整数: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] result = findErrorNums(nums);
        System.out.println("输出结果: [" + result[0] + "," + result[1] + "]");

        scanner.close();
    }
}
