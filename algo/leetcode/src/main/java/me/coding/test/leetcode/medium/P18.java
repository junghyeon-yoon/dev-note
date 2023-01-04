package me.coding.test.leetcode.medium;

import java.util.*;

public class P18 {
    // https://leetcode.com/problems/4sum/
    public static void main(String[] args) {
        var problem = new P18();
        System.out.println(problem.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
        System.out.println(problem.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(problem.fourSum(new int[]{2,2,2,2,2}, 8));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                int front = j+1;
                int back = nums.length-1;

                while(front < back) {
                    long sum = (long)nums[i] + nums[j] + nums[front] + nums[back];

                    if(sum==target) {
                        List<Integer> foundCase = List.of(nums[i], nums[j], nums[front], nums[back]);
                        if(!visited.contains(foundCase.toString())) {
                            visited.add(foundCase.toString());
                            result.add(foundCase);
                        }
                        front++;
                    } else if(sum < target) {
                        front++;
                    } else {
                        back--;
                    }
                }
            }
        }
        return result;
    }
}
