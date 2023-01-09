package me.coding.test.programmers.courses30;

public class L150369 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/150369
    public static void main(String[] args) {
        var problem = new L150369();
        System.out.println(problem.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        System.out.println(problem.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int indexD = n;
        int indexP = n;

        long answer = 0;

        while(indexD>0 || indexP>0) {
            // search non-zero index for given arrays
            while(indexD>0 && deliveries[indexD-1]==0) {
                indexD--;
            }

            while(indexP>0 && pickups[indexP-1]==0) {
                indexP--;
            }

            // add steps
            answer = indexD>=indexP?answer+indexD*2:answer+indexP*2;

            int carCap = cap;

            // delivery box
            while(carCap>0 && indexD>0) {
                if(deliveries[indexD-1]==0) {
                    indexD--;
                } else if(deliveries[indexD-1]<=carCap) {
                    carCap = carCap - deliveries[indexD-1];
                    deliveries[indexD-1] = 0;
                    indexD--;
                } else {
                    deliveries[indexD-1] = deliveries[indexD-1] - carCap;
                    carCap=0;
                }
            }

            carCap = 0;

            // pickup box
            while(carCap<cap && indexP>0) {
                if(pickups[indexP-1]==0) {
                    indexP--;
                } else if(pickups[indexP-1]<=(cap - carCap)) {
                    carCap = carCap + pickups[indexP-1];
                    pickups[indexP-1] = 0;
                    indexP--;
                } else {
                    pickups[indexP-1] = pickups[indexP-1] - (cap - carCap);
                    carCap=cap;
                }
            }
        }

        return answer;
    }
}
