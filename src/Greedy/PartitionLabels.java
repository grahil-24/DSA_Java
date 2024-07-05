package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        //storing character and their last occuring index
        for(int i=0; i<len; i++){
            map.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;

        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            int end_tmp = map.get(c);
            if(end_tmp > end){
                end = end_tmp;
            }
            if(end == i){
                res.add(end - start +1);
                start = end+1;
                end = start;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        System.out.println(p.partitionLabels("ababcbacadefegdehijhklij"));
    }

}
