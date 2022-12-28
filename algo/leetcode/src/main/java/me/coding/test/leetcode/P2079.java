package me.coding.test.leetcode;

public class P2079 {

    // https://leetcode.com/problems/watering-plants/
    public static void main(String[] args) {
        var problem = new P2079();

        System.out.println(problem.wateringPlants(new int[]{2,2,3,3}, 5));
        System.out.println(problem.wateringPlants(new int[]{1,1,1,4,2,3}, 4));
        System.out.println(problem.wateringPlants(new int[]{7,7,7,7,7,7,7}, 8));
    }
    
    public int wateringPlants(int[] plants, int capacity) {
        int step = 0;

        int levelOfCan = capacity;

        for(int i=0; i<plants.length; i++) {
            step++;
            levelOfCan = levelOfCan-plants[i];

            if(i+1 < plants.length && levelOfCan < plants[i+1]) {
                levelOfCan = capacity;
                step = step + ((i + 1) * 2);
            }
        }

        return step;
    }
}
