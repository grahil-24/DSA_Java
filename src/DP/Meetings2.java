package DP;

import java.util.*;

public class Meetings2 {

    static class Interval {
       public int start, end;
       public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }


    public int minMeetingRooms(List<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });

        int res = 0;

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < intervals.size(); i++) {
            if(visited.contains(i)){
                continue;
            }
            visited.add(i);

            Interval prev = intervals.get(i);
            for(int j = i+1; j<intervals.size(); j++){
                if(visited.contains(j)){
                    continue;
                }
                if(intervals.get(j).start >= prev.end){
                    prev = intervals.get(j);
                    visited.add(j);
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Meetings2 meetings = new Meetings2();
        Interval i1 = new Interval(0, 40);
        Interval i2 = new Interval(5, 10);
        Interval i3 = new Interval(15, 20);
//        Interval i4 = new Interval(4, 8);
//        Interval i5 = new Interval(5, 9);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
//        intervals.add(i4);
//        intervals.add(i5);
        System.out.println(meetings.minMeetingRooms(intervals));
    }
}
