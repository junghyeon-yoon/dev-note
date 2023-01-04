package me.coding.test.leetcode.medium;

import java.util.*;

public class P15 {
    // https://leetcode.com/problems/3sum/
    public static void main(String[] args) {
        var problem = new P15();
        System.out.println(problem.threeSum(new int[]{-2,0,1,1,2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> resultList = new ArrayList<>();
        Set<String> dedupFilter = new HashSet<>();


        for(int i=0; i<sortedNums.length; i++) {
            int front = 0;
            int back = sortedNums.length-1;

            while(front < back) {
                int sum = sortedNums[front] + sortedNums[i] + sortedNums[back];
                if(i<=front || i>=back) {
                    break;
                } else {
                    if(sum < 0) {
                        front++;
                    } else if(sum > 0) {
                        back--;
                    } else {
                        List<Integer> resultCase = List.of(sortedNums[front++], sortedNums[i], sortedNums[back--]);
                        if(!dedupFilter.contains(resultCase.toString())) {
                            dedupFilter.add(resultCase.toString());
                            resultList.add(resultCase);
                        }
                    }
                }
            }
        }

        return resultList;
    }
}
