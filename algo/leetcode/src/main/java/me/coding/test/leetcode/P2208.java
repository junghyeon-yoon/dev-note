package me.coding.test.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class P2208 {

    // https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
    public static void main(String[] args) {
        var problem = new P2208();

        System.out.println(problem.halveArray(new int[]{5,19,8,1}));
        System.out.println(problem.halveArray(new int[]{3,8,20}));
    }
    
    public int halveArray(int[] nums) {
        
        Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        double sum = 0;

        for(double num:nums) {
            queue.add(num);
            sum = sum + num;
        }
        
        double targetValue = (double)sum / 2d;

        int k = 0;

        while(targetValue>0) {
            k++;
            double num = queue.poll()/2d;
            targetValue = targetValue - num;
            queue.add(num);
        }

        return k;
    }
}
