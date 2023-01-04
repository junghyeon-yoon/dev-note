package me.coding.test.leetcode.medium;

import java.util.Arrays;

public class P16 {
    // https://leetcode.com/problems/3sum-closest/
    public static void main(String[] args) {
        var problem = new P16();
        System.out.println(problem.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(problem.threeSumClosest(new int[]{0,0,0}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        nums = Arrays.stream(nums).sorted().toArray();

        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i=1;i<nums.length-1;i++) {
            int front = 0;
            int back= nums.length-1;

            while (front < i && i < back) {
                int sum = nums[front] + nums[i] + nums[back];
                if(Math.abs(target-closestSum) > Math.abs(target-sum)) {
                    closestSum = sum;
                }

                if(sum < target) {
                    front++;
                } else if(sum > target) {
                    back--;
                } else {
                    break;
                }
            }
        }

        return closestSum;
    }
}
