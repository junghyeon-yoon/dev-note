package me.coding.test.leetcode;

public class P807 {

    // https://leetcode.com/problems/max-increase-to-keep-city-skyline/
    public static void main(String[] args) {
        var problem = new P807();

        System.out.println(problem.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
        System.out.println(problem.maxIncreaseKeepingSkyline(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
    }
    
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int[] north2south = new int[grid.length];
        int[] west2east = new int[grid.length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid.length; j++) {
                west2east[j] = Math.max(west2east[j], grid[i][j]);
                north2south[i] = Math.max(north2south[i], grid[i][j]);
            }
        }

        int sum = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid.length; j++) {
                 sum = sum + Math.min(west2east[j], north2south[i]) - grid[i][j];
            }
        }

        return sum;
    }
}
