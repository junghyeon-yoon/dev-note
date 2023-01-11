package me.coding.test.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1443 {
    // https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
    public static void main(String[] args) {
        var problem = new P1443();
        System.out.println(problem.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, List.of(false,false,true,false,true,true,false)));
    }
    // 트리가 아님, 그래프!

    Map<Integer, List<Integer>> treeMap = new HashMap<>();
    boolean[] visited;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        visited = new boolean[n];

        // build tree
        for(int[] edge:edges) {
            treeMap.putIfAbsent(edge[0], new ArrayList<>());
            treeMap.putIfAbsent(edge[1], new ArrayList<>());
            treeMap.computeIfPresent(edge[0], (k, v)-> {
                v.add(edge[1]);
                return v;
            });
            treeMap.computeIfPresent(edge[1], (k, v)-> {
                v.add(edge[0]);
                return v;
            });
        }

        int time = traverse(0, hasApple);

        return time;
    }

    public int traverse(int vertex, List<Boolean> hasApple) {
        int subTime = 0;

        if(!visited[vertex]) {
            visited[vertex] = true;
        } else {
            return 0;
        }

        List<Integer> children = treeMap.get(vertex);

        if(children!=null && !children.isEmpty()) {
            for(int child:children) {
                subTime += traverse(child, hasApple);
            }
        }

        if(vertex!=0 && (hasApple.get(vertex) || subTime > 0)) {
            // hasApple
            subTime += 2;
        }

        return subTime;
    }
}
