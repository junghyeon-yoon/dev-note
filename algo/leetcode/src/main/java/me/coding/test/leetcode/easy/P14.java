package me.coding.test.leetcode.easy;

import java.util.Arrays;

public class P14 {
    // https://leetcode.com/problems/longest-common-prefix/
    public static void main(String[] args) {
        var problem = new P14();
        System.out.println(problem.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(problem.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(problem.longestCommonPrefix(new String[]{"a","aa","aaa"}));
        System.out.println(problem.longestCommonPrefix(new String[]{"aaa","aaa","aaa"}));
        System.out.println(problem.longestCommonPrefix(new String[]{"aaa","aaa","aaa", "a"}));
        System.out.println(problem.longestCommonPrefix(new String[]{}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        } else if(strs.length == 1) {
            return strs[0];
        } else {
            Arrays.sort(strs);
            String longestPrefix = strs[0];

            for(int i=1; i<strs.length; i++) {
                int length = Math.min(longestPrefix.length(), strs[i].length());
                for(int j=0; j<length; j++) {
                    if(longestPrefix.charAt(j)!=strs[i].charAt(j)) {
                        longestPrefix = longestPrefix.substring(0, j);
                        break;
                    }
                }
            }

            return longestPrefix;
        }
    }
}
