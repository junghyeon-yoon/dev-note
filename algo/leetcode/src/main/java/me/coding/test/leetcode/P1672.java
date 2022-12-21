package me.coding.test.leetcode;

import java.util.Arrays;

public class P1672 {

    // https://leetcode.com/problems/richest-customer-wealth/
    public static void main(String[] args) {
        var problem = new P1672();
        int[][] accounts =
                {{2,8,7},
                {7,1,3},
                {1,9,5}};

        System.out.println(problem.maximumWealth(accounts));
    }

    public int maximumWealth(int[][] accounts) {
        var max = 0;
        for(var account : accounts) {
            var sum = Arrays.stream(account).sum();
            max = sum>max?sum:max;
        }

        return max;
    }
}
