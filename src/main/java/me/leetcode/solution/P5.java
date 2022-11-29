package me.leetcode.solution;

public class P5 {
    // https://leetcode.com/problems/longest-palindromic-substring/
    public static void main(String[] args) {
        var problem = new P5();
        System.out.println(problem.longestPalindrome("abb"));
    }

    public String longestPalindrome(String s) {

        if(s.length()%2==0) {
            var temp = new StringBuilder("#");

            for(var ch:s.toCharArray()) {
                temp.append(ch).append("#");
            }

            s = temp.toString();
        } else {
            var temp = new StringBuilder("");

            for(var ch:s.toCharArray()) {
                temp.append(ch).append("#");
            }

            s = temp.toString();
        }

        int[] length = new int[s.length()];
        var biggestPos = 0;
        for(var i=0; i<s.length();i++) {
            length[i] = checkLengthOfPalindromicAt(s, i);
            if(length[i]>length[biggestPos]) {
                biggestPos = i;
            }
        }

        var temp = new StringBuilder("");
        for(var ch:s.substring(biggestPos-length[biggestPos], biggestPos+length[biggestPos]+1).toCharArray()) {
            if('#' == ch) {
                continue;
            }
            temp.append(ch);
        }
        return temp.toString();
    }

    public int checkLengthOfPalindromicAt(String s, int position) {
        if(position==0){
            return 0;
        } else if(position==s.length()-1) {
            return 0;
        } else {
            var front = position;
            var back = position;

            while(front>0 && back<s.length()) {
                front--;
                back++;

                if( front<0 || back>s.length()-1 || s.charAt(front)!=s.charAt(back)) {
                    front++;
                    back--;
                    break;
                }

            }

            return back - position;
        }
    }
}
