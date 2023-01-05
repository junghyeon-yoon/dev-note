package me.coding.test.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class P452 {

    // https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
    public static void main(String[] args) {
        var problem = new P452();

        System.out.println(problem.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(problem.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(problem.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int shotCount = 0;

        for(int i=0; i<points.length; i++) {
            int balloons = 0;
            while(i+balloons < points.length && points[i][1] >= points[i+balloons][0]) {
                balloons++;
            }
            shotCount++;
            i = i + (balloons-1);
        }
        return shotCount;
    }
}
