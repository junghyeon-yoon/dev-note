package me.coding.test.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P22 {

    // https://leetcode.com/problems/generate-parentheses/
    public static void main(String[] args) {
        var problem = new P22();
        System.out.println(problem.generateParenthesis(3));
        System.out.println(problem.generateParenthesis(1));
    }

    class Node {
        public int iter;
        public int openParentheses;
        public int closeParentheses;
        public String value;

        Node(int iter, int openParentheses, int closeParentheses, String value) {
            this.iter = iter;
            this.openParentheses = openParentheses;
            this.closeParentheses = closeParentheses;
            this.value = value;
        }

        public Node open() {
            iter++;
            openParentheses--;
            value = value+"(";
            return this;
        }

        public Node close() {
            iter++;
            closeParentheses--;
            value = value+")";
            return this;
        }

        public Node clone() {
            return new Node(iter, openParentheses, closeParentheses, value);
        }
    }

    public List<String> generateParenthesis(int n) {
        Queue<Node> queue = new LinkedList<>();

        Node initNode = new Node(1, n - 1, n, "(");
        queue.add(initNode);

        int iter = 1;

        while(iter < n*2) {
            Node polled = queue.poll();
            iter = polled.iter;
            if(polled.openParentheses<=polled.closeParentheses
                    && polled.openParentheses>=0
                    && polled.closeParentheses>=0
            ) {
                queue.add(polled.clone().open());
                queue.add(polled.clone().close());
            }
        }

        return queue.stream().filter(node -> node.openParentheses==0 && node.closeParentheses==0).map(node -> node.value).toList();
    }
}
