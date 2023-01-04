package me.coding.test.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P2244 {

    // https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
    public static void main(String[] args) {
        var problem = new P2244();
        System.out.println(
                problem.minimumRounds(
                        new int[]{2,2,3,3,2,4,4,4,4,4}
                )
        );

        System.out.println(
                problem.minimumRounds(
                        new int[]{2,3,3}
                )
        );
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num:tasks) {
            map.putIfAbsent(num, 0);
            map.computeIfPresent(num, (k, v) -> v+1);
        }

        int round = 0;

        for(int key:map.keySet()) {
            int count = map.get(key);
            while(count>1) {
                if(count%3==0) {
                    count = count - 3;
                    round++;
                } else if(count%2 == 0) {
                    count = count - 2;
                    round++;
                } else {
                    count = count - 3;
                    round++;
                }
            }
            if(count>0) {
                return -1;
            }
        }
        return round;
    }
}
