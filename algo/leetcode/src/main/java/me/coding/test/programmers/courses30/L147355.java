package me.coding.test.programmers.courses30;

import java.math.BigDecimal;
import java.math.BigInteger;

public class L147355 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/147355
    public static void main(String[] args) {
        var problem = new L147355();
        System.out.println(problem.solution("3141592", "271"));
        System.out.println(problem.solution("500220839878", "7"));
        System.out.println(problem.solution("10203", "15"));
        System.out.println(problem.solution("1", "1"));
        System.out.println(problem.solution("2", "1"));
        System.out.println(problem.solution("10000000000000000000000000000000", "10"));
        System.out.println(problem.solution("999999999999999999999999999999999999", "999999999999999999"));
    }

    public int solution(String t, String p) {
        int answer = 0;
        
        int lengthOfTarget = p.length();
        long valueOfTarget = Long.valueOf(p);
        
        int left = 0;
        
        while(left+lengthOfTarget <= t.length()) {
            String sub;
            if(t.length() == left+lengthOfTarget) {
                sub = t.substring(left);
            } else {
                sub = t.substring(left, left+lengthOfTarget);
            }

            if(valueOfTarget >= Long.valueOf(sub)) {
                answer++;
            }

            left++;
        }
        
        return answer;
    }
}
