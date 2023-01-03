package me.coding.test.programmers.courses30;

public class L148653 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/148653
    public static void main(String[] args) {
        var problem = new L148653();
        System.out.println(problem.solution(16));
        System.out.println(problem.solution(2554));
    }
    public int solution(int storey) {
        int answer = 0;

        int[] nums = new int[String.valueOf(storey).length()+1];

        int index = 0;

        while(storey > 0) {
            nums[index++] = storey % 10;
            storey = storey / 10;
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 5) {
                answer = answer + nums[i];
            } else if(nums[i] > 5) {
                answer = answer + (10-nums[i]);
                nums[i+1]++;
            } else {
                if(nums[i+1] < 5) {
                    answer = answer + nums[i];
                } else {
                    answer = answer + (10-nums[i]);
                    nums[i+1]++;
                }
            }
        }

        return answer;
    }
}
