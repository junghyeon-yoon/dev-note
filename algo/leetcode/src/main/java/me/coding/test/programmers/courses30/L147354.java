package me.coding.test.programmers.courses30;

import java.util.Arrays;
import java.util.Comparator;

public class L147354 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/147354
    public static void main(String[] args) {
        var problem = new L147354();
        System.out.println(problem.solution(new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}}, 2,2,3));
    }

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int[]>() {

            @Override
            public int compare(int[] arg0, int[] arg1) {
                return arg0[col-1]==arg1[col-1]?arg1[0]-arg0[0]:arg0[col-1]-arg1[col-1];
            }
        });  
        
        int[] s_i = new int[row_end-row_begin+1];

        for(int i=row_begin-1; i<row_end; i++) {
            for(int j=0; j<data[i].length; j++) {
                s_i[i-row_begin+1] = s_i[i-row_begin+1] + (data[i][j] % (i+1));
            }

            answer = answer ^ s_i[i-row_begin+1];
        }



        return answer;
    }
}
