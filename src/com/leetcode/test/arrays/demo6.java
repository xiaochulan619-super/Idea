package com.leetcode.test.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo6 {
    /**
     * 找出[1, n]范围内但没有出现在数组中的数字
     *
     * @param nums 输入数组，包含n个整数，每个数在[1, n]范围内
     * @return 消失的数字列表
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入数组长度：");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.print("请输入数组元素（用空格分隔）：");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        List<Integer> result = findDisappearedNumbers(nums);

        System.out.print("输出: [");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i < result.size() - 1 ? "," : ""));
        }
        System.out.println("]");

        scanner.close();
    }
}

