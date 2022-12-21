package me.coding.test.leetcode;

public class P3 {

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static void main(String[] args) {
        var problem = new P3();
        System.out.println(problem.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0) {
            return 0;
        }
        var result = s.substring(0,1);

        for(var i=0;i<=s.length();i++) {
            for(var j=i;j<=s.length();j++) {
                var substring = s.substring(i, j);
                if(j == s.length()) {
                    if(result.length() < substring.length()) {
                        result = substring;
                    }
                } else if(j <= s.length() && substring.indexOf(s.charAt(j)) < 0) {
                    if(result.length() < substring.length()) {
                        result = substring;
                    }
                } else if(j <= s.length() && substring.indexOf(s.charAt(j)) > -1){
                    if(result.length() < substring.length()) {
                        result = substring;
                    }
                    break;
                }
            }
        }

//        System.out.println(result);
        return result.length();
    }
}
