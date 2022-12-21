package me.coding.test.leetcode;

public class P35 {

    // https://leetcode.com/problems/search-insert-position/description/
    public static void main(String[] args) {
        var problem = new P35();
        System.out.println(problem.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(problem.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(problem.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(problem.searchInsert(new int[]{1,3}, 0));
    }

    public int searchInsert(int[] nums, int target) {

        int front = 0;
        int back = nums.length-1;

        while (front <= back) {
            int mid =  (back + front) / 2;

            if (target < nums[mid]) back = mid - 1;
            else if (target > nums[mid]) front = mid + 1;
            else return mid;
        }

        return front;
    }
}
