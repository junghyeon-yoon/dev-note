package me.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class P118 {
    // https://leetcode.com/problems/pascals-triangle/

    public static void main(String[] args) {
        var problem = new P118();
        System.out.println(problem.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j==0) {
                    row.add(j, 1);
                } else if(i==j) {
                    row.add(j, 1);
                } else {
                    row.add(j, result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(row);
        }

        return result;
    }
}
