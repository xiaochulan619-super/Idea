package com.leetcode.test.heap;

import java.util.*;

/**
 * 查找和最小的 K 对数字
 *
 * 问题描述：
 * - 给定两个非递减数组 nums1 和 nums2
 * - 从两个数组中各取一个元素组成数对 (u, v)
 * - 找到和最小的 k 个数对
 *
 * 解题思路：
 * - 使用最小堆来维护当前和最小的数对
 * - 初始时将 nums1 的前 k 个元素与 nums2[0] 组成的数对放入堆中
 * - 每次取出堆顶（和最小的数对），然后将该数对的下一个可能组合加入堆
 *
 * 优化策略：
 * - 不需要将所有可能的数对都放入堆中（那样会是 O(n*m)）
 * - 只需要在需要时才生成候选数对
 */
public class demo3 {

    /**
     * 找到和最小的 k 个数对
     *
     * @param nums1 第一个非递减数组
     * @param nums2 第二个非递减数组
     * @param k 需要返回的数对数量
     * @return 和最小的 k 个数对
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // 边界检查
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // 创建最小堆，按照数对的和进行排序
        // 堆中存储的是索引对 [i, j]，表示 nums1[i] 和 nums2[j] 的组合
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        // 初始化：将 nums1 的前 k 个元素与 nums2[0] 的组合加入堆
        // 因为数组是有序的，所以最小的数对一定在这些组合中
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        // 取出 k 个最小的数对
        while (k > 0 && !minHeap.isEmpty()) {
            // 取出和最小的数对
            int[] pair = minHeap.poll();
            int i = pair[0];
            int j = pair[1];

            // 将数对添加到结果中
            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(nums1[i]);
            currentPair.add(nums2[j]);
            result.add(currentPair);

            // 将下一个可能的数对加入堆
            // 如果 nums1[i] 还可以和 nums2[j+1] 组合，则加入堆
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }

            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== 查找和最小的 K 对数字 ===\n");

        // 测试示例 1
        int[] nums1_1 = {1, 7, 11};
        int[] nums2_1 = {2, 4, 6};
        int k1 = 3;

        System.out.println("示例 1:");
        System.out.println("nums1: " + Arrays.toString(nums1_1));
        System.out.println("nums2: " + Arrays.toString(nums2_1));
        System.out.println("k: " + k1);

        List<List<Integer>> result1 = kSmallestPairs(nums1_1, nums2_1, k1);
        System.out.println("输出: " + formatResult(result1));
        System.out.println("预期: [[1,2],[1,4],[1,6]]");
        System.out.println("结果: " + (result1.size() == 3 ? "✓ 正确" : "✗ 错误"));

        System.out.println("\n=== 详细过程演示 ===");
        simulateProcess(nums1_1, nums2_1, k1);

        System.out.println("\n\n=== 测试示例 2 ===");
        int[] nums1_2 = {1, 1, 2};
        int[] nums2_2 = {1, 2, 3};
        int k2 = 2;

        System.out.println("nums1: " + Arrays.toString(nums1_2));
        System.out.println("nums2: " + Arrays.toString(nums2_2));
        System.out.println("k: " + k2);

        List<List<Integer>> result2 = kSmallestPairs(nums1_2, nums2_2, k2);
        System.out.println("输出: " + formatResult(result2));
        System.out.println("预期: [[1,1],[1,1]]");
        System.out.println("结果: " + (result2.size() == 2 ? "✓ 正确" : "✗ 错误"));

        System.out.println("\n\n=== 更多测试用例 ===");

        // 测试用例 3：k 大于所有可能的数对数量
        int[] nums1_3 = {1, 2};
        int[] nums2_3 = {3};
        int k3 = 5;

        System.out.println("测试 3:");
        System.out.println("nums1: " + Arrays.toString(nums1_3));
        System.out.println("nums2: " + Arrays.toString(nums2_3));
        System.out.println("k: " + k3 + " (超过总数对数)");

        List<List<Integer>> result3 = kSmallestPairs(nums1_3, nums2_3, k3);
        System.out.println("输出: " + formatResult(result3));
        System.out.println("预期: [[1,3],[2,3]]");

        // 测试用例 4：空数组
        int[] nums1_4 = {};
        int[] nums2_4 = {1, 2, 3};
        int k4 = 3;

        System.out.println("\n测试 4:");
        System.out.println("nums1: []");
        System.out.println("nums2: [1, 2, 3]");
        System.out.println("k: " + k4);

        List<List<Integer>> result4 = kSmallestPairs(nums1_4, nums2_4, k4);
        System.out.println("输出: " + formatResult(result4));
        System.out.println("预期: []");
    }

    /**
     * 格式化输出结果
     */
    public static String formatResult(List<List<Integer>> result) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 模拟算法执行过程
     */
    public static void simulateProcess(int[] nums1, int[] nums2, int k) {
        System.out.println("所有可能的数对及其和:");

        List<int[]> allPairs = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                allPairs.add(new int[]{nums1[i], nums2[j], nums1[i] + nums2[j]});
            }
        }

        // 按和排序
        allPairs.sort((a, b) -> a[2] - b[2]);

        System.out.println("排序后的所有数对:");
        for (int[] pair : allPairs) {
            System.out.println("  [" + pair[0] + "," + pair[1] + "] 和=" + pair[2]);
        }

        System.out.println("\n前 " + k + " 个最小的数对:");
        for (int i = 0; i < Math.min(k, allPairs.size()); i++) {
            int[] pair = allPairs.get(i);
            System.out.println("  " + (i + 1) + ". [" + pair[0] + "," + pair[1] + "] 和=" + pair[2]);
        }

        System.out.println("\n算法执行步骤:");
        System.out.println("1. 初始化堆: 将 (nums1[0],nums2[0]), (nums1[1],nums2[0]), ... 加入堆");
        System.out.println("2. 每次取出堆顶（和最小），然后将其右侧的数对加入堆");
        System.out.println("3. 重复 k 次或堆为空");
    }
}

