package com.leetcode.test.singlestack;

import java.util.Scanner;
import java.util.Stack;

public class demo1 {
    /**
     * 计算折扣后的最终价格
     *
     * @param prices 商品价格数组
     * @return 折扣后的价格数组
     */
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = prices[index];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入商品价格数量：");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.print("请输入商品价格（用空格分隔）：");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int[] result = finalPrices(prices);

        System.out.print("输出: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i < result.length - 1 ? "," : ""));
        }
        System.out.println("]");

        scanner.close();
    }
}

