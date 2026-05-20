package com.leetcode.test.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class demo4 {
    public static boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        
        for (int num : target) {
            maxHeap.offer((long) num);
            sum += num;
        }
        
        while (maxHeap.peek() != 1) {
            long maxVal = maxHeap.poll();
            long otherSum = sum - maxVal;
            
            if (otherSum < 1 || maxVal <= otherSum) {
                return false;
            }
            
            long prevVal = maxVal % otherSum;
            
            if (prevVal == 0) {
                if (otherSum == 1) {
                    prevVal = 1;
                } else {
                    return false;
                }
            }
            
            sum = otherSum + prevVal;
            maxHeap.offer(prevVal);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[] target1 = {9, 3, 5};
        System.out.println(isPossible(target1)); // true
        
        int[] target2 = {1, 1, 1, 2};
        System.out.println(isPossible(target2)); // false
        
        int[] target3 = {8, 5};
        System.out.println(isPossible(target3)); // true
    }
}
