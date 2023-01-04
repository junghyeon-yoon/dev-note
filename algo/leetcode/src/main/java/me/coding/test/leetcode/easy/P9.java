package me.coding.test.leetcode.easy;

public class P9 {
    // https://leetcode.com/problems/palindrome-number/
    public static void main(String[] args) {
        var problem = new P9();
        System.out.println(problem.isPalindrome(121));
        System.out.println(problem.isPalindrome(-121));
        System.out.println(problem.isPalindrome(10));
        System.out.println(problem.isPalindrome(1));
    }

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        } else if(x < 10) {
            return true;
        } else {
            String num = String.valueOf(x);
            int front = 0;
            int back = num.length()-1;
            boolean result = true;

            while(front < back) {
                if(num.charAt(front++)!=num.charAt(back--)) {
                    result = false;
                    break;
                }
            }

            return result;
        }
    }
}
