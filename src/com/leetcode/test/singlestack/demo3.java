package com.leetcode.test.singlestack;

import java.util.Scanner;
import java.util.Stack;

public class demo3 {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入柱子数量: ");
        int n = scanner.nextInt();
        
        int[] heights = new int[n];
        System.out.print("请输入" + n + "个非负整数表示柱子高度: ");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        
        int result = largestRectangleArea(heights);
        System.out.println("最大矩形面积: " + result);
        
        scanner.close();
    }
}
