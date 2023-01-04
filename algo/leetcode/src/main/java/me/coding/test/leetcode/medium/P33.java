package me.coding.test.leetcode.medium;

public class P33 {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static void main(String[] args) {
        var problem = new P33();
        System.out.println(problem.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(problem.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(problem.search(new int[]{1}, 1));
    }

    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length-1;
        int resultIndex = -1;

        while(left <= right) {
            int mid = (left+right)/2;

            if(nums[left]==target) {
                resultIndex = left;
                break;
            } else if(nums[mid]==target) {
                resultIndex = mid;
                break;
            } else if(nums[right]==target) {
                resultIndex = right;
                break;
            }

            // check pivot index and find sorted side
            if(nums[left] < nums[mid]) {
                // sorted side: left
                if(target > nums[left] && target < nums[mid]) {
                    left++;
                    right = mid-1;
                } else {
                    right--;
                    left = mid+1;
                }
            } else {
                //sorted side: right
                if(target > nums[mid] && target < nums[right]) {
                    right--;
                    left = mid+1;
                } else {
                    left++;
                    right = mid-1;
                }
            }
        }

        return resultIndex; 
    }
}
