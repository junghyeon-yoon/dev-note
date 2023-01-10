package me.coding.test.programmers.courses30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L150368 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/150368
    public static void main(String[] args) {
        var problem = new L150368();
        System.out.println(problem.solution(new int[][]{{40, 10000},{25, 10000}}, new int[]{7000, 9000}));
    }

    Set<String> discountRateSet = new HashSet<>();

    int topEmoPlus = 0;
    int topTotal = 0;

    int[][] users;
    int[] emoticons;

    public int[] solution(int[][] users, int[] emoticons) {

        this.users = Arrays.copyOf(users, users.length);
        this.emoticons = Arrays.copyOf(emoticons, emoticons.length);

        int[] discountRate = new int[emoticons.length];
        Arrays.fill(discountRate, 40);

        preOrder(discountRate);

        int[] answer = {topEmoPlus, topTotal};
        return answer;
    }

    public void preOrder(int[] discountRate) {
        String join = Arrays.toString(discountRate);
        if(!discountRateSet.contains(join)) {
            discountRateSet.add(join);
            // calculate
            int emoPlus = 0;
            int total = 0;

            for(int[] user:users) {
                int subTotal = 0;
                for(int i=0; i<emoticons.length; i++) {
                    if(user[0] <= discountRate[i]) { // buy
                        subTotal = subTotal + (emoticons[i] * (100-discountRate[i]) / 100);
                    }

                    if(subTotal>=user[1]) { // emo plus
                        emoPlus++;
                        subTotal = 0;
                        break;
                    }
                }
                total = total + subTotal;
            }

            if(emoPlus>topEmoPlus) {
                topEmoPlus = emoPlus;
                topTotal = total;
            } else if(emoPlus==topEmoPlus && total>topTotal) {
                topTotal = total;
            }
        } else {
            return;
        }

        for(int i=0;i<discountRate.length;i++) {
            int[] copy = Arrays.copyOf(discountRate, discountRate.length);
            if(copy[i]>=20) {
                copy[i] = copy[i]-10;
                preOrder(copy);
            }
        }
    }
}
