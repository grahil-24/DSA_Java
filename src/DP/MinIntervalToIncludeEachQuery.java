package DP;

import java.util.HashMap;
import java.util.Map;

public class MinIntervalToIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] interval: intervals){
            int size = interval[interval.length-1] - interval[0] + 1;
            for(int i = interval[0]; i <= interval[interval.length-1]; i++){
                int val = map.getOrDefault(i, Integer.MAX_VALUE);
                if(size < val){
                    map.put(i, size);
                }
            }
        }

        for(int i = 0; i < queries.length; i++){
            int val = map.getOrDefault(queries[i], -1);
            res[i] = val;
        }
        return res;
    }

    public static void main(String[] args) {
        MinIntervalToIncludeEachQuery m = new MinIntervalToIncludeEachQuery();
        int[] res = m.minInterval(new int[][]{{2,3}, {2, 5}, {1,8}, {20,25}},new int[]{2,19,5,22});
        for(int num: res){
            System.out.print(STR."\{num} ");
        }
        System.out.println();
    }
}
