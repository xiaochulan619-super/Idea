package com.leetcode.test.review;

import java.util.Arrays;

public class demo1 {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
    
    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        System.out.println("输入: " + Arrays.toString(digits1));
        System.out.println("输出: " + Arrays.toString(plusOne(digits1)));
        System.out.println();
        
        int[] digits2 = {4, 3, 2, 1};
        System.out.println("输入: " + Arrays.toString(digits2));
        System.out.println("输出: " + Arrays.toString(plusOne(digits2)));
        System.out.println();
        
        int[] digits3 = {9};
        System.out.println("输入: " + Arrays.toString(digits3));
        System.out.println("输出: " + Arrays.toString(plusOne(digits3)));
        System.out.println();
        
        int[] digits4 = {9, 9, 9};
        System.out.println("输入: " + Arrays.toString(digits4));
        System.out.println("输出: " + Arrays.toString(plusOne(digits4)));
    }
}
