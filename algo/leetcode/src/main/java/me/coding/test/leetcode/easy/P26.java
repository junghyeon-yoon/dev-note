package me.coding.test.leetcode.easy;

public class P26 {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    public static void main(String[] args) {
        var problem = new P26();
        System.out.println(problem.removeDuplicates(new int[]{1,1,1,1}));
    }

    public int removeDuplicates(int[] nums) {
        int count = 1;
        int prevValue = nums[0];
        int lastIndex = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i]==prevValue) {

            } else { //nums[i]>prevValue
                count++;
                prevValue = nums[i];
                nums[lastIndex++] = nums[i];
            }
        }

        return count;
    }
}
