package me.coding.test.leetcode.easy;

import java.util.*;

public class P1337 {

    // https://leetcode.com/problems/roman-to-integer/
    public static void main(String[] args) {
        var problem = new P1337();
        int[][] mat =
                {{1,1,0,0,0},
                 {1,1,1,1,0},
                 {1,0,0,0,0},
                 {1,1,0,0,0},
                 {1,1,1,1,1}};

        System.out.println(problem.kWeakestRows(mat, 3));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();

        for(var i=0;i< mat.length;i++) {
            map.putIfAbsent(Arrays.stream(mat[i]).sum(), new Stack<>());
            int finalI = i;
            map.computeIfPresent(Arrays.stream(mat[i]).sum(), (integer, integers) -> {
                integers.push(finalI);
                return integers;
            });
        }
        List<Integer> list = map.keySet().stream().sorted().flatMap(integer -> map.get(integer).stream()).toList();
        int[] result = new int[k];
        var temp = list.subList(0, k);
        for(var i=0;i< temp.size();i++) {
            result[i] = temp.get(i);
        }

        return  result;
    }
}
