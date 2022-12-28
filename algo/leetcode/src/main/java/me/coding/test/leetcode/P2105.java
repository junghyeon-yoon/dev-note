package me.coding.test.leetcode;

public class P2105 {

    // https://leetcode.com/problems/watering-plants-ii/
    public static void main(String[] args) {
        var problem = new P2105();

        System.out.println(problem.minimumRefill(new int[]{2,2,3,3}, 5, 5));
        System.out.println(problem.minimumRefill(new int[]{2,2,3,3}, 3, 4));
        System.out.println(problem.minimumRefill(new int[]{5}, 10, 8));
    }
    
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0;
        int right = plants.length-1;
        int canA = capacityA;
        int canB = capacityB;
        int refill = 0;

        while(left <= right) {

            if(left < right) {
                if(canA < plants[left]) {
                    canA = capacityA;
                    refill++;
                }
                if(canB < plants[right]) {
                    canB = capacityB;
                    refill++;
                }
            } else {
                if(canA >= plants[left] || canB >= plants[right]) {
                    //do next
                } else if (capacityA >= plants[left]) {
                    canA = capacityA;
                    refill++;
                } else if (capacityB >= plants[right]) {
                    canB = capacityB;
                    refill++;
                }
            }

            if(canA >= plants[left]) {
                canA = canA - plants[left];
                left++;
            }

            if(canB >= plants[right]) {
                canB = canB - plants[right];
                right--;
            }
        }

        return refill;
    }
}
