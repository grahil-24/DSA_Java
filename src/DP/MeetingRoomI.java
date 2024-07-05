package DP;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
 }
}
public class MeetingRoomI {

    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0 || intervals.size() == 1){
            return true;
        }

        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for(Interval i : intervals) {
            pq.offer(i);
        }

        Interval prev = pq.poll();
        while(!pq.isEmpty()) {
            Interval i = pq.poll();
            if(i.start > prev.end) {
                prev =i;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Interval i = new Interval(5, 8);
        Interval i2 = new Interval(9, 15);
//        Interval i3 = new Interval(15, 20);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(i);
        intervals.add(i2);
//        intervals.add(i3);
        System.out.println(new MeetingRoomI().canAttendMeetings(intervals));
    }
}
