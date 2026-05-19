package com.leetcode.test.arrays;

import java.util.Scanner;

public class demo5 {
    /**
     * 统计数组中比每个元素小的数字数目
     *
     * @param nums 输入数组
     * @return 结果数组，每个位置表示对应元素有多少个比它小的数字
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] count = new int[101];

        for (int num : nums) {
            count[num]++;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < nums[i]; j++) {
                sum += count[j];
            }
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入数组长度：");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.print("请输入数组元素（用空格分隔）：");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int[] result = smallerNumbersThanCurrent(nums);
        
        System.out.print("输出: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i < result.length - 1 ? "," : ""));
        }
        System.out.println("]");
        
        scanner.close();
    }
}
