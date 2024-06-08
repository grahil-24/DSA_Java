package Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
       List<int[]> res = new ArrayList<>();
       for(int[] interval : intervals){
           //when current interval is less than the interval to be inserted
           //and they do not overlap or if newinterval is null, we insert
           //as is
           if(newInterval == null || interval[1] < newInterval[0]){
                res.add(interval);
            //when current interval does not overlap and is greater than the new
               //interval
           }else if(interval[0] > newInterval[1]){
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            //when both interval intersect
           }else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
           }
       }
       if(newInterval != null){
           res.add(newInterval);
       }
       return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] res = ii.insert(new int[][]{{2,3},{6,9}, {11,12}},new int[]{4,5});
        for(int i = 0; i<res.length; i++){
            System.out.println(STR."[\{res[i][0]} \{res[i][1]}] ");
        }
    }
}
