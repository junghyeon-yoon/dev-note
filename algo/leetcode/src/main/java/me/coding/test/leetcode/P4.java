package me.coding.test.leetcode;

public class P4 {

    // https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
    public static void main(String[] args) {
        var problem = new P4();
        System.out.println(problem.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

       if(nums1.length==0) {
           if(nums2.length%2==0) {
               var position = nums2.length/2;
               return (double)(nums2[position-1]+nums2[position])/2L;
           } else {
               var position = (nums2.length+1)/2;
               return nums2[position-1];
           }
       }

        if(nums2.length==0) {
            if(nums1.length%2==0) {
                var position = nums1.length/2;
                return (double)(nums1[position-1]+nums1[position])/2L;
            } else {
                var position = (nums1.length+1)/2;
                return nums1[position-1];
            }
        }

        var length = nums1.length + nums2.length;
        int[] nums = new int[length];

        var j = 0;
        var k = 0;

        for(var i=0; i<nums.length; i++) {

            if(j==nums1.length) {
                nums[i] = nums2[k++];
                continue;
            }

            if(k==nums2.length) {
                nums[i] = nums1[j++];
                continue;
            }

            if(nums1[j]>nums2[k]) {
                nums[i] = nums2[k++];
            } else {
                nums[i] = nums1[j++];
            }
        }

        if(nums.length%2==0) {
            var position = nums.length/2;
            return (double)(nums[position-1]+nums[position])/2L;
        } else {
            var position = (nums.length+1)/2;
            return nums[position-1];
        }
    }
}
