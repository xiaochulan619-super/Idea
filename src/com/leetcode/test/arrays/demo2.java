package com.leetcode.test.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class demo2 {
    /**
     * 将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列
     *
     * @param nums 原始数组，格式为 [x1,x2,...,xn,y1,y2,...,yn]
     * @param n 分割点，前n个元素为x部分，后n个元素为y部分
     * @return 重排后的数组
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];

        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }

        return result;
    }

    /**
     * 主方法，通过键盘录入方式获取数据并执行数组洗牌操作
     *
     * @param args 命令行参数数组
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入n的值: ");
        int n = scanner.nextInt();

        int[] nums = new int[2 * n];
        System.out.print("请输入" + (2 * n) + "个整数: ");
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] result = shuffle(nums, n);
        System.out.println("输出结果: " + Arrays.toString(result));

        scanner.close();
    }
}
