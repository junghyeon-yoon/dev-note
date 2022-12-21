package me.coding.test.programmers;

public class Lesson12973 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/12973
    public static void main(String[] args) {
        var problem = new Lesson12973();
//        System.out.println(problem.solution("baabaa"));
        System.out.println(problem.solution("bbssaa"));
    }
    public int solution(String s) {
        if(s.length()==0) {
            return 1;
        }
        if(s.length()%2==1) {
            return 0;
        }

        char[] temp = new char[s.length()];
        int tempPointer = -1;

        for(int i=0; i<s.length();i++) {
            if(tempPointer==-1) {
                tempPointer++;
                temp[tempPointer] = s.charAt(i);
            } else {
                if(temp[tempPointer] == s.charAt(i)) {
                    tempPointer--;
                } else {
                    tempPointer++;
                    temp[tempPointer] = s.charAt(i);
                }
            }
        }

        return tempPointer==-1?1:0;
    }
}
