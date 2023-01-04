package me.coding.test.leetcode.medium;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class P1962 {

    // https://leetcode.com/problems/remove-stones-to-minimize-the-total/
    public static void main(String[] args) {
        var problem = new P1962();

        System.out.println(problem.minStoneSum(new int[]{5,4,9}, 2));
        System.out.println(problem.minStoneSum(new int[]{4,3,6,7}, 3));
    }
    
    /*
     * Remove stone from largest pile in given k step
     * pile[i] = pile[i] - floor(pile[i]/2)
     */
    public int minStoneSum(int[] piles, int k) {
        
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int pile:piles) {
            queue.add(pile);
        }
        
        while(k>0) {
            k--;
            int targetPile = queue.poll();
            queue.add(targetPile - Math.floorDiv(targetPile, 2));
        }

        return queue.stream().collect(Collectors.summingInt(Integer::intValue));
    }
}
