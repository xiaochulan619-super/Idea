package com.leetcode.test.singlestack;

import java.util.Scanner;
import java.util.Stack;

public class demo2 {
    /**
     * 计算下一个更高温度的天数差
     *
     * @param temperatures 每天的温度数组
     * @return 下一个更高温度出现在几天后的数组
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入温度数据数量：");
        int n = scanner.nextInt();

        int[] temperatures = new int[n];
        System.out.print("请输入温度（用空格分隔）：");
        for (int i = 0; i < n; i++) {
            temperatures[i] = scanner.nextInt();
        }

        int[] answer = dailyTemperatures(temperatures);

        System.out.print("输出: [");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + (i < answer.length - 1 ? "," : ""));
        }
        System.out.println("]");

        scanner.close();
    }
}
