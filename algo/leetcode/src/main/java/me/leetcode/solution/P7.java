package me.leetcode.solution;

public class P7 {
    // https://leetcode.com/problems/reverse-integer/
    public static void main(String[] args) {
        var problem = new P7();
        System.out.println(problem.reverse(-123));
    }

    public int reverse(int x) {


        var builder = new StringBuilder();

        for(char ch:String.valueOf(x).toCharArray()) {
            if('-'!=ch) {
                builder.insert(0, ch);
            }
        }

        if(x<0) {
            builder.insert(0, '-');
        }
        try {
            return Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
