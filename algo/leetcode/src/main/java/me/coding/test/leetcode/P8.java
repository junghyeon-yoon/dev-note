package me.coding.test.leetcode;

public class P8 {
    // https://leetcode.com/problems/string-to-integer-atoi/
    public static void main(String[] args) {
        var problem = new P8();
        System.out.println(problem.myAtoi("-91283472332"));
    }

    public int myAtoi(String s) {
        int index = 0;

        if(s.length()==0) {
            return 0;
        }

        while(index < s.length() && s.charAt(index)==' ') {
            index++;
        }

        boolean isNegative = false;

        if(index < s.length() && s.charAt(index)=='+') {
            isNegative = false;
            index++;
        } else if(index < s.length() && s.charAt(index)=='-') {
            isNegative = true;
            index++;
        }

        int result = 0;

        while(index < s.length()) {
            if(s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                int value = s.charAt(index) - '0';
                if(isNegative && (result*-1 < Integer.MIN_VALUE/10 || ( result*-1 == Integer.MIN_VALUE/10 && value > Integer.MIN_VALUE%10*-1))) {
                    return Integer.MIN_VALUE;
                } else if(!isNegative && (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && value > Integer.MAX_VALUE%10))) {
                    return Integer.MAX_VALUE;
                } else {
                    result = result * 10 + value;
                    index++;
                }
            } else {
                break;
            }
        }

        return isNegative
                ?result*-1
                :result;
    }
}
