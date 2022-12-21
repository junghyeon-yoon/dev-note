package me.coding.test.leetcode;

public class P11 {
    // https://leetcode.com/problems/container-with-most-water/
    public static void main(String[] args) {
        var problem = new P11();
        System.out.println(problem.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(problem.maxArea(new int[]{1,1}));
        System.out.println(problem.maxArea(new int[]{9,0}));
    }

    public int maxArea(int[] height) {
        int area = 0;
        int areaTemp = 0;
        int front = 0;
        int back = height.length-1;

        while(front < back) {
            if(height[front] < height[back]) {
                areaTemp = (back-front) * height[front];
                if(areaTemp>area) {
                    area = areaTemp;
                }
                front++;
            } else {
                areaTemp = (back-front) * height[back];
                if(areaTemp>area) {
                    area = areaTemp;
                }
                back--;
            }
        }

        return area;
    }
}
