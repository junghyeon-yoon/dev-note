package me.coding.test.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P448 {

    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    public static void main(String[] args) {
        var problem = new P448();
        System.out.println(problem.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(problem.findDisappearedNumbers(new int[]{1,1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        Set<Integer> numSet = new HashSet<>();
        for(int i=1; i<=nums.length; i++) {
            numSet.add(i);
        }

        for(int num:nums) {
            numSet.remove(num);
        }

        resultList.addAll(numSet);

        return resultList;
    }
}
