package com.leetcode.test.review;

import java.util.Arrays;

public class demo2 {
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        
        if (n < 3) {
            return false;
        }
        
        int i = 0;
        
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        
        if (i == 0 || i == n - 1) {
            return false;
        }
        
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        
        return i == n - 1;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {2, 1};
        System.out.println("输入: " + Arrays.toString(arr1));
        System.out.println("输出: " + validMountainArray(arr1));
        System.out.println();
        
        int[] arr2 = {3, 5, 5};
        System.out.println("输入: " + Arrays.toString(arr2));
        System.out.println("输出: " + validMountainArray(arr2));
        System.out.println();
        
        int[] arr3 = {0, 3, 2, 1};
        System.out.println("输入: " + Arrays.toString(arr3));
        System.out.println("输出: " + validMountainArray(arr3));
        System.out.println();
        
        int[] arr4 = {0, 1, 2, 3, 5, 4, 3, 2, 0};
        System.out.println("输入: " + Arrays.toString(arr4));
        System.out.println("输出: " + validMountainArray(arr4));
        System.out.println();
        
        int[] arr5 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("输入: " + Arrays.toString(arr5));
        System.out.println("输出: " + validMountainArray(arr5));
    }
}
