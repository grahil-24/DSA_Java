package BinarySearch;

import java.util.Arrays;

public class KokoEatsBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        int max = Arrays.stream(piles).max().getAsInt();
        int min_amt = max + 1;
        int l = 1;
        int r = max;
        while(l <= r){
            int mid = l + (r - l)/2;
            Double time = 0.0;
            for(int amt: piles){
                time += Math.ceil((double) amt /mid);
            }
            if(time <= h){
                if(mid < min_amt){
                    min_amt = mid;
                }
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return min_amt;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
    }
}
