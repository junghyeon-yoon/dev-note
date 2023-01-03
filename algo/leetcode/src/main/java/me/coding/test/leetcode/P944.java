package me.coding.test.leetcode;

public class P944 {

    // https://leetcode.com/problems/delete-columns-to-make-sorted/
    public static void main(String[] args) {
        var problem = new P944();
        System.out.println(
                problem.minDeletionSize(
                        new String[]{"cba","daf","ghi"}
                )
        );

        System.out.println(
                problem.minDeletionSize(
                        new String[]{"a","b"}
                )
        );

        System.out.println(
                problem.minDeletionSize(
                        new String[]{"zyx","wvu","tsr"}
                )
        );
    }

    public int minDeletionSize(String[] strs) {
        int answer = 0;

        if(strs.length==1) {
            return answer;
        }

        for(int i=0; i<strs[0].length(); i++) {
            char prevChar = 0;
            for(int j=0; j<strs.length; j++) {
                if(prevChar <= strs[j].charAt(i)) { // check next
                    prevChar = strs[j].charAt(i);
                } else { // mark as deleted
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
