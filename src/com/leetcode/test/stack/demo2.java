package com.leetcode.test.stack;

import java.util.Scanner;
import java.util.Stack;

public class demo2 {
    /**
     * 计算逆波兰表达式的值
     *
     * @param tokens 逆波兰表达式字符串数组
     * @return 表达式的计算结果
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入tokens数量：");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] tokens = new String[n];
        System.out.print("请输入tokens（用空格分隔）：");
        String line = scanner.nextLine();
        tokens = line.split("\\s+");

        int result = evalRPN(tokens);

        System.out.println("输出: " + result);

        scanner.close();
    }
}

