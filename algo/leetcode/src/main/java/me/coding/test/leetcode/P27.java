package me.coding.test.leetcode;

public class P27 {
    // https://leetcode.com/problems/remove-element/
    public static void main(String[] args) {
        var problem = new P27();
        System.out.println(problem.removeElement(new int[]{2,2,2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int position = 0;

        for(int i=0; i<nums.length; i++) {
            if(val != nums[i]) {
                nums[position++] = nums[i];
            }
        }

        return position;
    }
}
