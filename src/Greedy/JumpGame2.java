package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JumpGame2 {

//    public int jump(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[nums.length - 1] = 0;
//
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//
//        queue.add(new int[]{0,nums.length-1});
//
//        for(int i = nums.length-2; i >= 0; i--){
//            List<int[]> temp = new ArrayList<>();
//            while(!queue.isEmpty()){
//                int[] poll = queue.poll();
//                temp.add(poll);
//                if(nums[i] + i >= poll[1]){
//                    dp[i] = 1 + poll[0];
//                    int[] arr = {1 + poll[0], i};
//                    queue.add(arr);
//                    break;
//                }
//            }
//            queue.addAll(temp);
//        }
//        return dp[0];
//    }

    public int jump(int[] nums) {

        int l = 0, r = 0;
        int res = 0;
        while(r < nums.length - 1){
            int max = nums[l];
            int max_index = l;
            for(int i = l+1; i <= r; i++){
                if(nums[i] >= max){
                    max = nums[i];
                    max_index = i;
                }
            }
            int temp = r;
            r = max + max_index;
            l = temp + 1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {


        JumpGame2 jp = new JumpGame2();
        System.out.println(jp.jump(new int[]{1,2,1,1,1}));
    }
}
