package me.coding.test.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P2279 {

    // https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
    public static void main(String[] args) {
        var problem = new P2279();
        // System.out.println(problem.maximumBags(new int[]{2,3,4,5}, new int[]{1,2,4,4}, 2));
        // System.out.println(problem.maximumBags(new int[]{10,2,2}, new int[]{2,2,0}, 100));
        System.out.println(problem.maximumBags(
            new int[]{54,18,91,49,51,45,58,54,47,91,90,20,85,20,90,49,10,84,59,29,40,9,100,1,64,71,30,46,91}, 
            new int[]{14,13,16,44,8,20,51,15,46,76,51,20,77,13,14,35,6,34,34,13,3,8,1,1,61,5,2,15,18}, 
            77
            ));
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        Map<Integer, Integer> extraCapas = new HashMap<>();

        for(int i=0; i<capacity.length; i++) {
            int extraCapa = capacity[i] - rocks[i];
            extraCapas.putIfAbsent(extraCapa, 0);
            extraCapas.computeIfPresent(extraCapa, (k, v)->v+1);
        }

        List<Integer> keySet = extraCapas.keySet().stream().sorted().collect(Collectors.toList());

        int numOfFullBags = 0;

        for(int extraCapa: keySet) {
            if(extraCapa > additionalRocks) {
                break;
            } else if(extraCapa==0) {
                numOfFullBags = numOfFullBags + extraCapas.get(extraCapa);
            } else {
                int requiredBags = additionalRocks/extraCapa;
                int availableBags = extraCapas.get(extraCapa);

                if(requiredBags <= availableBags) {
                    numOfFullBags = numOfFullBags + requiredBags;
                    break;
                } else {
                    numOfFullBags = numOfFullBags + availableBags;
                    additionalRocks = additionalRocks - (availableBags * extraCapa);
                }
            }
        }

        return numOfFullBags;
    }
}
