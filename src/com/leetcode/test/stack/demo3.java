package com.leetcode.test.stack;

import java.util.Scanner;
import java.util.Stack;

public class demo3 {
    /**
     * 计算每个函数的独占时间
     *
     * @param n 函数数量
     * @param logs 日志列表
     * @return 每个函数的独占时间数组
     */
    public static int[] exclusiveTime(int n, String[] logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += timestamp - prevTime;
                }
                stack.push(id);
                prevTime = timestamp;
            } else {
                result[stack.pop()] += timestamp - prevTime + 1;
                prevTime = timestamp + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入函数数量n：");
        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.print("请输入logs数量：");
        int m = scanner.nextInt();
        scanner.nextLine();

        String[] logs = new String[m];
        System.out.println("请输入logs（每行一个）：");
        for (int i = 0; i < m; i++) {
            logs[i] = scanner.nextLine();
        }

        int[] result = exclusiveTime(n, logs);

        System.out.print("输出: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i < result.length - 1 ? "," : ""));
        }
        System.out.println("]");

        scanner.close();
    }
}
