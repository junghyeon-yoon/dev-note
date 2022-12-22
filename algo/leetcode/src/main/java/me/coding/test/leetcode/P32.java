package me.coding.test.leetcode;

import java.util.Stack;

public class P32 {
    // https://leetcode.com/problems/longest-valid-parentheses/
    public static void main(String[] args) {
        var problem = new P32();
        System.out.println(problem.longestValidParentheses("(()")); //2
        System.out.println(problem.longestValidParentheses(")()())")); //4
        System.out.println(problem.longestValidParentheses(")()())()()()(")); //6
        System.out.println(problem.longestValidParentheses(")()()()())()()()(")); //8
        System.out.println(problem.longestValidParentheses("()(()")); //2
        System.out.println(problem.longestValidParentheses("())")); //2
        System.out.println(problem.longestValidParentheses(""));
    }

    class Node {
        public char ch;
        public int index;

        Node(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    public int longestValidParentheses(String s) {
        if(s.length()<2) {
            return 0;
        }

        int index = 0;
        Stack<Node> stack = new Stack<>();

        while(index < s.length()) {
            char ch = s.charAt(index);
            Node node = new Node(ch, index++);

            if(stack.isEmpty()) {
                stack.push(node);
            } else {
                if(ch == '(') {
                    stack.push(node);
                } else { // ch == ')'
                    Node prev = stack.pop();
                    if(prev.ch=='(') {
                        // remove
                    } else {
                        // put
                        stack.push(prev);
                        stack.push(node);
                    }
                }

            }
        }


        int longest = 0;

        if(!stack.isEmpty()) {
            int backIndex = s.length();

            while(!stack.isEmpty()) {
                int currentIndex = stack.pop().index;
                if(currentIndex < backIndex) {
                    int tempLongest = backIndex-currentIndex-1;
                    if(tempLongest > longest) {
                        longest = tempLongest;
                    }
                    backIndex = currentIndex;
                }
            }

            if(backIndex>0) {
                if(backIndex > longest) {
                    longest = backIndex;
                }
            }
        } else {
            longest = s.length();
        }

        return longest;
    }
}
