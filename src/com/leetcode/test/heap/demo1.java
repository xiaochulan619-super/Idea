package com.leetcode.test.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

/**
 * 堆(Heap)详解
 *
 * 堆是一种特殊的完全二叉树数据结构
 *
 * 主要特点：
 * 1. 完全二叉树：除了最后一层，其他层都是满的，且节点尽量靠左
 * 2. 堆序性：父节点与子节点之间满足特定的大小关系
 *
 * 堆的分类：
 * - 最小堆(Min Heap)：父节点 <= 子节点，堆顶是最小值
 * - 最大堆(Max Heap)：父节点 >= 子节点，堆顶是最大值
 *
 * 常见应用：
 * - 优先队列(PriorityQueue)
 * - 堆排序
 * - Top K 问题
 * - 求中位数
 */
public class demo1 {
    public static void main(String[] args) {

        System.out.println("=== 1. 使用 PriorityQueue 实现最小堆 ===");
        // Java 的 PriorityQueue 默认是最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 添加元素（自动维护堆结构）
        minHeap.offer(5);
        minHeap.offer(3);
        minHeap.offer(8);
        minHeap.offer(1);
        minHeap.offer(4);

        System.out.println("最小堆: " + minHeap);
        System.out.println("堆顶元素(最小值): " + minHeap.peek());

        System.out.println("\n依次出队（从小到大排序）:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        System.out.println("\n=== 2. 使用 PriorityQueue 实现最大堆 ===");
        // 通过 Collections.reverseOrder() 创建最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(5);
        maxHeap.offer(3);
        maxHeap.offer(8);
        maxHeap.offer(1);
        maxHeap.offer(4);

        System.out.println("最大堆: " + maxHeap);
        System.out.println("堆顶元素(最大值): " + maxHeap.peek());

        System.out.println("\n依次出队（从大到小排序）:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();

        System.out.println("\n=== 3. 堆的基本操作 ===");
    }
}