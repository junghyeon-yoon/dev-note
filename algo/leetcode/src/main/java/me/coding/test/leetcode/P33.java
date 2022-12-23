package me.coding.test.leetcode;

public class P33 {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static void main(String[] args) {
        var problem = new P33();
        System.out.println(problem.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(problem.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(problem.search(new int[]{1}, 1));
    }

    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        
        int front = 0;
        int back = nums.length-1;

        while(front<=back){
        	int center = (front+back)/2;

        	if(nums[center]==target) {
                return center;
            } else if(
                nums[center]>=nums[0] && target>=nums[0] || 
                nums[center]<nums[0] && target<nums[0]
            ) {
        		if(target<nums[center]) {
                    back=center-1;
                } else {
                    front=center+1;
                }
        	} else {
        		if(target<nums[center]) {
                    front=center+1;
                } else {
                    back=center-1;
                }
        	}
        }
        return -1;
    }
}
