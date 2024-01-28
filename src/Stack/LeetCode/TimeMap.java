package Stack.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TimeMap {

    private static class Pair{
        String value;
        int timeStamp;

        Pair(String value, int timeStamp){
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp);
        if(map.containsKey(key)){
            List<Pair> list = map.get(key);
            list.add(pair);
            map.put(key, list);
        }else{
            map.put(key, new ArrayList<>(Arrays.asList(pair)));
        }
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return null;
        }
        List<Pair> list = map.get(key);
        int length = list.size();
        if(length == 0){
            return null;
        }
        if(timestamp < list.getFirst().timeStamp){
            return null;
        }
        int s = 0;
        int e = length-1;
        while(s <= e){
            int mid = (s + e)/2;
            if(list.get(mid).timeStamp < timestamp){
                s = mid + 1;
            }else if(list.get(mid).timeStamp > timestamp){
                e = mid -1;
            }else{
                return list.get(mid).value;
            }
        }
        return list.get(e).value;
    }

    public static void main(String[] args) {
        TimeMap tm = new TimeMap();
        tm.set("love", "high", 10);
        tm.set("love", "low", 20);
        System.out.println(tm.get("love", 5));
    }
}