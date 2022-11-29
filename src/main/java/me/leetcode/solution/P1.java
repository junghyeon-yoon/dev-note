package me.leetcode.solution;

public class P1 {

    // https://leetcode.com/problems/two-sum/
    public static void main(String[] args) {
        var problem = new P1();
        System.out.println(problem.twoSum(new int[]{3, 2, 4, 5}, 6));
    }

    public int[] twoSum(int[] nums, int target) {

        for(var i=0; i< nums.length; i++) {
            for(var j=0; j< nums.length; j++) {
                if(i!=j && target==nums[i]+nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }
}
