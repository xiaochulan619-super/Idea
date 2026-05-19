package com.leetcode.test.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class demo1 {
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入数组长度: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.print("请输入" + n + "个整数: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int[] result = getConcatenation(nums);
        System.out.println("输出结果: " + Arrays.toString(result));
        
        scanner.close();
    }
}
