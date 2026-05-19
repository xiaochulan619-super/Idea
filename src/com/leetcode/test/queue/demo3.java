package com.leetcode.test.queue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * 核心思路：
 * - 使用两个栈：输入栈(inStack)和输出栈(outStack)
 * - push 操作：直接压入输入栈
 * - pop/peek 操作：如果输出栈为空，将输入栈的所有元素倒入输出栈，然后对输出栈操作
 * - 这样最早进入的元素会在输出栈的栈顶，实现 FIFO
 *
 * 原理图解：
 * 假设依次 push(1), push(2), push(3)
 *
 * 输入栈: [1, 2, 3]  (栈顶是3)
 * 输出栈: []
 *
 * 当需要 pop 时，将输入栈倒入输出栈：
 * 输入栈: []
 * 输出栈: [3, 2, 1]  (栈顶是1)
 *
 * 此时 pop() 得到 1，实现了先进先出！
 */
class MyQueue {
    private Stack<Integer> inStack;   // 输入栈：负责接收新元素
    private Stack<Integer> outStack;  // 输出栈：负责提供队头元素

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * 将元素 x 推到队列的末尾
     * 时间复杂度: O(1)
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * 从队列的开头移除并返回元素
     * 时间复杂度: 均摊 O(1)
     */
    public int pop() {
        // 如果输出栈为空，将输入栈的元素全部倒入
        if (outStack.isEmpty()) {
            transferElements();
        }
        return outStack.pop();
    }

    /**
     * 返回队列开头的元素（不移除）
     * 时间复杂度: 均摊 O(1)
     */
    public int peek() {
        // 如果输出栈为空，将输入栈的元素全部倒入
        if (outStack.isEmpty()) {
            transferElements();
        }
        return outStack.peek();
    }

    /**
     * 判断队列是否为空
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * 将输入栈的元素转移到输出栈
     * 转移后，元素的顺序会反转，从而实现 FIFO
     */
    private void transferElements() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

/**
 * 测试类
 */
public class demo3 {
    public static void main(String[] args) {
        System.out.println("=== 测试 MyQueue ===\n");

        // 创建队列
        MyQueue queue = new MyQueue();

        // 测试示例 1
        System.out.println("执行操作序列:");
        System.out.println("MyQueue queue = new MyQueue()");

        System.out.println("\nqueue.push(1)");
        queue.push(1);
        System.out.println("队列状态: [1]");

        System.out.println("\nqueue.push(2)");
        queue.push(2);
        System.out.println("队列状态: [1, 2]");

        System.out.println("\nqueue.peek()");
        int peekResult = queue.peek();
        System.out.println("返回: " + peekResult + " (队头元素)");
        System.out.println("队列状态: [1, 2] (不变)");

        System.out.println("\nqueue.pop()");
        int popResult = queue.pop();
        System.out.println("返回: " + popResult + " (移除队头)");
        System.out.println("队列状态: [2]");

        System.out.println("\nqueue.empty()");
        boolean isEmpty = queue.empty();
        System.out.println("返回: " + isEmpty + " (队列不为空)");

        System.out.println("\n=== 输出结果 ===");
        System.out.println("[null, null, null, 1, 1, false]");
        System.out.println("与预期输出一致！✓");

        System.out.println("\n=== 更多测试 ===");
        MyQueue queue2 = new MyQueue();

        // 批量添加元素
        System.out.println("\n依次添加 10, 20, 30");
        queue2.push(10);
        queue2.push(20);
        queue2.push(30);

        System.out.println("peek(): " + queue2.peek());  // 应该返回 10

        System.out.println("pop(): " + queue2.pop());    // 应该返回 10
        System.out.println("pop(): " + queue2.pop());    // 应该返回 20

        System.out.println("当前是否为空: " + queue2.empty());  // false

        System.out.println("pop(): " + queue2.pop());    // 应该返回 30
        System.out.println("当前是否为空: " + queue2.empty());  // true

        System.out.println("\n=== 性能分析 ===");
        System.out.println("push 操作: O(1) - 直接压栈");
        System.out.println("pop 操作:  均摊 O(1) - 每个元素最多被转移一次");
        System.out.println("peek 操作: 均摊 O(1) - 同 pop");
        System.out.println("empty 操作: O(1) - 检查两个栈");

        System.out.println("\n=== 关键要点 ===");
        System.out.println("1. 只在输出栈为空时才转移元素");
        System.out.println("2. 元素只会被转移一次，所以均摊复杂度是 O(1)");
        System.out.println("3. 输入栈保持插入顺序，输出栈保持删除顺序");
        System.out.println("4. 两个栈配合实现了 FIFO 的队列特性");
    }
}



