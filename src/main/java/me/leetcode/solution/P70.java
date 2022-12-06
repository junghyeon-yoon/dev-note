package me.leetcode.solution;

public class P70 {
    // https://leetcode.com/problems/climbing-stairs/

    public static void main(String[] args) {
        var problem = new P70();
        System.out.println(problem.climbStairs(5));
    }

    static int[] memo;

    public int climbStairs(int n) {
        memo = new int[n+1];
        return step(n);
    }

    public int step(int count) {
        if(count <= 2) {
            memo[count] = count;
            return memo[count];
        }

        if(memo[count] > 0) {
            return memo[count];
        }

        memo[count] = step(count-1) + step(count-2);

        return memo[count];
    }
}
