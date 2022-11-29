package me.leetcode.solution;

import java.util.*;

public class P1342 {

    // https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
    public static void main(String[] args) {
        var problem = new P1342();
        System.out.println(problem.numberOfSteps(100));
    }

    public int numberOfSteps(int num) {
        var step = 0;

        while(num>0) {
            var isEven = num%2==0?true:false;

            if(isEven) {
                num = num / 2;
            } else {
                num--;
            }

            step++;
        }

        return step;
    }
}
