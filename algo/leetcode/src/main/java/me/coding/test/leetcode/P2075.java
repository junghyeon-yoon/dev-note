package me.coding.test.leetcode;

public class P2075 {

    // https://leetcode.com/problems/decode-the-slanted-ciphertext/
    public static void main(String[] args) {
        var problem = new P2075();
        System.out.println(problem.decodeCiphertext("ch   ie   pr", 3));
        System.out.println(problem.decodeCiphertext("iveo    eed   l te   olc", 4));
        System.out.println(problem.decodeCiphertext("coding", 1));
    }

    public String decodeCiphertext(String encodedText, int rows) {
        if(encodedText.length()==0) {
            return "";
        }

        int column = encodedText.length()/rows;

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<column; i++) {
            int j = 0;
            while(i+j<encodedText.length()) {
                builder.append(encodedText.charAt(i+j));
                j = j+column+1;
            }
        }

        return builder.toString().stripTrailing();
    }
}
