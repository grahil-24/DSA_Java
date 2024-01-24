package Stack;
import java.util.*;
import java.util.Arrays;

public class CarFleet {

    static class Pair implements Comparable<Pair>{

        int pos;
        int speed;

        Pair(int pos, int speed){
            this.pos = pos;
            this.speed = speed;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.pos - pair.pos;
        }
    }


    public static int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        Pair[] fleetPair = new Pair[length];
        for(int i = 0; i<length; i++){
            fleetPair[i] = new Pair(position[i], speed[i]);
        }
        Arrays.sort(fleetPair);
        Double[] time = new Double[length];
        for(int i = 0; i<length; i++){
            time[i] = Math.ceil((target - fleetPair[i].pos) / (double)fleetPair[i].speed);
        }
        int i = length-1;
        int fleetCount = 0;
        while(i>=0){
            int j = i-1;
            while(j>=0){
                if(time[j] <= time[i]){
                    j--;
                }else{
                    break;
                }
            }
            fleetCount++;
            i = j;
        }
        return fleetCount;
    }

    public static void main(String[] args) {
        System.out.println(CarFleet.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }

}
