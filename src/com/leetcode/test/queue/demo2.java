package com.leetcode.test.queue;

public class demo2 {
    
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int targetTickets = tickets[k];  // 位置k的人需要买的票数
        
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                // 位置k及之前的人：最多买targetTickets张票
                time += Math.min(tickets[i], targetTickets);
            } else {
                // 位置k之后的人：最多买targetTickets-1张票
                // 因为当k买到最后一张票时，过程就结束了
                time += Math.min(tickets[i], targetTickets - 1);
            }
        }
        
        return time;
    }
    
    public static void main(String[] args) {
        // 测试示例1
        int[] tickets1 = {2, 3, 2};
        int k1 = 2;
        System.out.println("示例1输出: " + timeRequiredToBuy(tickets1, k1));
        
        // 测试示例2
        int[] tickets2 = {5, 1, 1, 1};
        int k2 = 0;
        System.out.println("示例2输出: " + timeRequiredToBuy(tickets2, k2));
    }
}
