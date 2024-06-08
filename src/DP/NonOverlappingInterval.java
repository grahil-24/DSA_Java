package DP;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {


    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null){
            return 0;
        }
        int len = intervals.length;
        if(len == 0 || len == 1){
            return 0;
        }
        int res= 0;
        int index = 0;

        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        for(int i = 1; i < len; i++){
            if(intervals[i][0] < intervals[index][1]){
                if(intervals[i][1] <= intervals[index][1]){
                    index = i;
                    res++;
                    continue;
                }else{
                    res++;
                    continue;
                }
            }
            index = i;
        }
        return res;
    }

    public static void main(String[] args) {
        NonOverlappingInterval noi = new NonOverlappingInterval();
        System.out.println(noi.eraseOverlapIntervals(new int[][]{{1, 2}, {2,3}}));
    }
}
