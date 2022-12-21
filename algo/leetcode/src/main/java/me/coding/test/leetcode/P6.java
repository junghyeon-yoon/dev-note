package me.coding.test.leetcode;

public class P6 {
    // https://leetcode.com/problems/zigzag-conversion/
    public static void main(String[] args) {
        var problem = new P6();
        System.out.println(problem.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if(numRows==1) {
            return s;
        }
        var stringBuilderArray = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) {
            stringBuilderArray[i] = new StringBuilder();
        }
        int iter = 0;
        boolean direction = false; //false: up, true: down

        for(char ch:s.toCharArray()) {
            stringBuilderArray[iter].append(ch);

            if(iter==numRows-1) {
                direction = true;
            } else if(iter==0) {
                direction = false;
            }

            if(direction) {
                iter--;
            } else {
                iter++;
            }
        }

        for(int i=numRows-1; i>0; i--) {
            stringBuilderArray[i-1].append(stringBuilderArray[i].toString());
        }

        return stringBuilderArray[0].toString();
    }
}
