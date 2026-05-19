package com.leetcode.test.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo1 {
    /**
     * 构建目标数组的栈操作序列
     *
     * @param target 目标数组
     * @param n 整数流范围[1, n]
     * @return 操作序列列表
     */
    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int currentIndex = 0;

        for (int i = 1; i <= n && currentIndex < target.length; i++) {
            if (i == target[currentIndex]) {
                result.add("Push");
                currentIndex++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入target数组长度：");
        int m = scanner.nextInt();

        int[] target = new int[m];
        System.out.print("请输入target数组元素（用空格分隔）：");
        for (int i = 0; i < m; i++) {
            target[i] = scanner.nextInt();
        }

        System.out.print("请输入n的值：");
        int n = scanner.nextInt();

        List<String> result = buildArray(target, n);

        System.out.print("输出: [");
        for (int i = 0; i < result.size(); i++) {
            System.out.print("\"" + result.get(i) + "\"" + (i < result.size() - 1 ? "," : ""));
        }
        System.out.println("]");

        scanner.close();
    }
}
