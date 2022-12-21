package me.coding.test.leetcode;

public class P58 {
    // https://leetcode.com/problems/length-of-last-word/
    public static void main(String[] args) {
        var problem = new P58();
        System.out.println(problem.lengthOfLastWord(" "));
        System.out.println(problem.lengthOfLastWord("a"));
        System.out.println(problem.lengthOfLastWord("Hello World"));
        System.out.println(problem.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(problem.lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {

        int count=0;
        boolean reset = false;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == ' ') {
                reset = true;
            } else if(ch >= 'A' && ch <= 'z') {
                if(reset) {
                    count = 0;
                    reset = false;
                }
                count++;
            }
        }

        return count;
    }
}
