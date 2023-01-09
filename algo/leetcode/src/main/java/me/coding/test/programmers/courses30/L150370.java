package me.coding.test.programmers.courses30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L150370 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/150370
    public static void main(String[] args) {
        var problem = new L150370();
        System.out.println(problem.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));
    }

    // Days from 2000-00-00
    public long convertDay(String dayString) {
        String[] splitedToday = dayString.split("\\.");
        long days = Long.valueOf(splitedToday[2])-1L + (Long.valueOf(splitedToday[1])-1L)*28L + (Long.valueOf(splitedToday[0])-2000L)*12L*28L;

        return days;
    }

    public int[] solution(String today, String[] terms, String[] privacies) {

        long todayDay = convertDay(today);

        Map<String, Integer> termMap = new HashMap<>();

        for(String term:terms) {
            String[] splitedTerm = term.split(" ");
            termMap.put(splitedTerm[0], Integer.valueOf(splitedTerm[1]));
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];

            String[] splitedPrivacy = privacy.split(" ");
            long optInDay = convertDay(splitedPrivacy[0]);

            Integer validateIn = termMap.get(splitedPrivacy[1]);

            long validAt = optInDay + validateIn * 28L;

            if(validAt-todayDay<=0) {
                result.add(i+1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
