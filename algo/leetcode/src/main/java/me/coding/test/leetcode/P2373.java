package me.coding.test.leetcode;

public class P2373 {

    // https://leetcode.com/problems/largest-local-values-in-a-matrix/
    public static void main(String[] args) {
        var problem = new P2373();

        System.out.println(problem.largestLocal(
            new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}}
            ));
    }

    public int[][] largestLocal(int[][] grid) {
        int[][] generatedMatix = new int[grid.length-2][grid.length-2];
        
        for(int i=0; i<generatedMatix.length; i++) {
            for(int j=0; j<generatedMatix.length; j++) {
                generatedMatix[i][j] = getMaxNumberInGrid(grid, i, j);
            }    
        }

        return generatedMatix;
    }

    public int getMaxNumberInGrid(int[][] grid, int i, int j) {
        
        int maxNum = 1;

        for(int ii=i; ii<i+3; ii++) {
            for(int jj=j; jj<j+3; jj++) {
                maxNum = Math.max(maxNum, grid[ii][jj]);
            }
        }

        return maxNum;
    }
}
