package com.leetcode.test.heap;

import java.util.PriorityQueue;
import java.util.Collections;

/**
 * 最后一块石头的重量
 *
 * 问题描述：
 * - 每次选出两块最重的石头进行粉碎
 * - 如果重量相等，两块都完全粉碎
 * - 如果重量不等，轻的粉碎，重的变为差值
 * - 返回最后剩下的石头重量
 *
 * 解题思路：
 * - 使用最大堆来维护石头重量，方便快速获取最重的两块石头
 * - 每次取出堆顶的两个元素（最重的两块）
 * - 如果不相等，将差值重新放入堆中
 * - 重复直到堆中只剩0个或1个元素
 */
public class demo2 {

    /**
     * 计算最后一块石头的重量
     *
     * @param stones 石头重量数组
     * @return 最后剩下的石头重量，如果没有则返回0
     */
    public static int lastStoneWeight(int[] stones) {
        // 创建最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 将所有石头加入最大堆
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // 当堆中至少有2块石头时，继续粉碎
        while (maxHeap.size() > 1) {
            // 取出最重的两块石头
            int y = maxHeap.poll(); // 最重的
            int x = maxHeap.poll(); // 第二重的

            // 如果重量不相等，将差值放回堆中
            if (x != y) {
                maxHeap.offer(y - x);
            }
            // 如果相等，两块都粉碎了，不需要做任何操作
        }

        // 返回最后剩下的石头重量，如果堆为空则返回0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        System.out.println("=== 最后一块石头的重量 ===\n");

        // 测试示例
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("示例 1:");
        System.out.println("输入: [2, 7, 4, 1, 8, 1]");
        int result1 = lastStoneWeight(stones1);
        System.out.println("输出: " + result1);
        System.out.println("预期: 1");
        System.out.println("结果: " + (result1 == 1 ? "✓ 正确" : "✗ 错误"));

        System.out.println("\n=== 详细过程演示 ===");
        simulateProcess(stones1);

        System.out.println("\n\n=== 更多测试用例 ===");

        // 测试用例 2：只有一块石头
        int[] stones2 = {5};
        System.out.println("测试 2:");
        System.out.println("输入: [5]");
        int result2 = lastStoneWeight(stones2);
        System.out.println("输出: " + result2);
        System.out.println("预期: 5");
        System.out.println("结果: " + (result2 == 5 ? "✓ 正确" : "✗ 错误"));

        // 测试用例 3：两块相同的石头
        int[] stones3 = {3, 3};
        System.out.println("\n测试 3:");
        System.out.println("输入: [3, 3]");
        int result3 = lastStoneWeight(stones3);
        System.out.println("输出: " + result3);
        System.out.println("预期: 0");
        System.out.println("结果: " + (result3 == 0 ? "✓ 正确" : "✗ 错误"));

        // 测试用例 4：两块不同的石头
        int[] stones4 = {3, 7};
        System.out.println("\n测试 4:");
        System.out.println("输入: [3, 7]");
        int result4 = lastStoneWeight(stones4);
        System.out.println("输出: " + result4);
        System.out.println("预期: 4");
        System.out.println("结果: " + (result4 == 4 ? "✓ 正确" : "✗ 错误"));

        // 测试用例 5：所有石头重量相同
        int[] stones5 = {5, 5, 5, 5};
        System.out.println("\n测试 5:");
        System.out.println("输入: [5, 5, 5, 5]");
        int result5 = lastStoneWeight(stones5);
        System.out.println("输出: " + result5);
        System.out.println("预期: 0");
        System.out.println("结果: " + (result5 == 0 ? "✓ 正确" : "✗ 错误"));
    }

    /**
     * 模拟粉碎过程，展示每一步的操作
     */
    public static void simulateProcess(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        System.out.println("初始状态: " + maxHeap);
        System.out.println();

        int step = 1;
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            System.out.println("第 " + step + " 步:");
            System.out.println("  选出最重的两块石头: " + y + " 和 " + x);

            if (x == y) {
                System.out.println("  两块石头重量相等，都完全粉碎");
                System.out.println("  当前堆: " + maxHeap);
            } else {
                int newWeight = y - x;
                maxHeap.offer(newWeight);
                System.out.println("  重量不等，产生新石头: " + y + " - " + x + " = " + newWeight);
                System.out.println("  当前堆: " + maxHeap);
            }

            step++;
            System.out.println();
        }

        if (maxHeap.isEmpty()) {
            System.out.println("所有石头都粉碎了，返回 0");
        } else {
            System.out.println("最后剩下一块石头，重量为: " + maxHeap.peek());
        }
    }
}
