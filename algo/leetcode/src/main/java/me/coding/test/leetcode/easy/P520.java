package me.coding.test.leetcode.easy;

public class P520 {

    // https://leetcode.com/problems/detect-capital/
    public static void main(String[] args) {
        var problem = new P520();
        System.out.println(problem.detectCapitalUse("USA"));
        System.out.println(problem.detectCapitalUse("FlaG"));
    }

    public boolean detectCapitalUse(String word) {
        boolean foundFirstCapital = false;
        int count = 0;
        boolean result = false;

        for(int i=0;i<word.length(); i++) {
            if(word.charAt(i)>='A' && word.charAt(i)<='Z') {
                count++;
                if(i==0) {
                    foundFirstCapital=true;
                }
            }
        }

        if(foundFirstCapital==true) {
            if(count==word.length()) {
                result = true;
            } else if(count==1) {
                result = true;
            } else {
                result = false;
            }
        } else {
            if(count==0) {
                result = true;
            } else {
                result = false;
            }
        }

        return result;
    }
}
