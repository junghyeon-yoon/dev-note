package me.coding.test.programmers.courses30;

public class L148652 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/148652
    public static void main(String[] args) {
        var problem = new L148652();
        System.out.println(problem.solution(1, 1, 5));
        System.out.println(problem.solution(20, 1, (int)Math.pow(5, 20)));
    }
    public int solution(int n, long l, long r) {
        int answer = 0;
        answer = (int)countOne(n, r) - (int)countOne(n, l-1L);
        return answer;
    }

    public long countOne(int n, long index) {
        long count = 0;

        while(true) {
            if(index < 6) { // in last step of iter
                if(index < 3) {
                    count = count + index;
                } else {
                    count = count + index - 1; // exclude 0 "11011"
                }
                break;
            }

            n--;
            long unitSize = (long) Math.pow(5, n); // number of size of previous group
            long numberOfOne = (long) Math.pow(4, n); // number of 1 of previous group

            if(index<=2L * unitSize) { // left hand side
                long quotient = index / unitSize;
                count = count + (quotient * numberOfOne); // count 1
                index = index % unitSize; // index of next iter
            } else if(index>3L * unitSize) { // right hand side
                long quotient = index / unitSize;
                count = count + ((quotient - 1) * numberOfOne); // count 1
                index = index % unitSize; // index of next iter
            } else { // center, could be no 1 here. count all left hand
                count = count + (2L * numberOfOne);
                break;
            }
        }

        return count;
    }
}
