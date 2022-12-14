package me.leetcode.solution;

import java.util.Stack;

public class P20 {
    // https://leetcode.com/problems/valid-parentheses/
    public static void main(String[] args) {
        var problem = new P20();
        System.out.println(problem.isValid("()"));
        System.out.println(problem.isValid("()[]{}"));
        System.out.println(problem.isValid("(]"));
        System.out.println(problem.isValid("]["));
    }

    public boolean isValid(String s) {
        if(s.length()<2) {
            return false;
        } else {
            final char smallLeftBracket = '(';
            final char mediumLeftBracket = '{';
            final char largeLeftBracket = '[';

            final char smallRightBracket = ')';
            final char mediumRightBracket = '}';
            final char largeRightBracket = ']';

            Stack<String> stack = new Stack<>();

            for(char ch:s.toCharArray()) {
                if(ch==smallLeftBracket || ch==mediumLeftBracket || ch==largeLeftBracket) {
                    stack.push(String.valueOf(ch));
                } else {
                    if(stack.isEmpty()) {
                        return false;
                    }
                    String pop = stack.pop();
                    switch (pop.charAt(0)) {
                        case smallLeftBracket:
                            if(ch!=smallRightBracket) {
                                return false;
                            }
                            break;
                        case mediumLeftBracket:
                            if(ch!=mediumRightBracket) {
                                return false;
                            }
                            break;
                        case largeLeftBracket:
                            if(ch!=largeRightBracket) {
                                return false;
                            }
                            break;
                    }

                }
            }

            return stack.isEmpty();
        }
    }
}
