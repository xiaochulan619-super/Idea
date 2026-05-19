package com.leetcode.test.review;

import java.util.ArrayDeque;
import java.util.Deque;

public class demo3 {
    
    public static String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        boolean[] inStack = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            
            if (inStack[c - 'a']) {
                continue;
            }
            
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                char popped = stack.pop();
                inStack[popped - 'a'] = false;
            }
            
            stack.push(c);
            inStack[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s1 = "bcabc";
        System.out.println("输入: " + s1);
        System.out.println("输出: " + removeDuplicateLetters(s1));
        System.out.println();
        
        String s2 = "cbacdcbc";
        System.out.println("输入: " + s2);
        System.out.println("输出: " + removeDuplicateLetters(s2));
    }
}
