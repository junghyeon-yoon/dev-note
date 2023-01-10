package me.coding.test.programmers.courses30;

import java.util.ArrayList;
import java.util.List;

public class L150367 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/150367
    public static void main(String[] args) {
        var problem = new L150367();
        System.out.println(problem.solution(new long[]{7, 42, 5}));
    }
    // 십진수를 이진수로 표현했을때, 그 표현이 그래프로 그려지는가.
    // 중위순회
    // 표현이 가능하면 1, 아니면 0
    // 1 <= numbers <= 10,000
    // 1 <= numbers[i] <= 10^15
    // 10^15 = 11 1000 1101 0111 1110 1010 0100 1100 0110 1000 0000 0000 0000 (12*4+2=50)
    // 포화 이진 트리 => 2^(n+1)-1
    // 000000010000000, child가 모두 0이면 parent도 0일 수 있음.
    public int[] solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for(long num:numbers) {
            String numString = Long.toBinaryString(num);

            int dummyCount = -1;
            int j=0;

            while(dummyCount<0) {
                dummyCount = ((int)Math.pow(2, j+1)-1) - numString.length();
                j++;
            }

            StringBuilder builder = new StringBuilder();

            for(int i=0;i<dummyCount; i++) {
                builder.append("0");
            }

            builder.append(numString);
            numString = builder.toString();

            // System.out.println("=====");
            // System.out.println(numString);

            boolean isOk = isValidTree(numString);

            answer.add(isOk?1:0);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean isValidTree(String tree) {

        if(tree.length()>=3) {
            if(tree.charAt(tree.length()/2) == '0' && (tree.charAt(tree.length()/4) == '1' || tree.charAt(tree.length()/4+tree.length()/2+1) == '1')){
                return false;
            } else {
                return isValidTree(tree.substring(0, tree.length()/2)) && isValidTree(tree.substring(tree.length()/2+1));
            }
        }

        return true;

    }
}
