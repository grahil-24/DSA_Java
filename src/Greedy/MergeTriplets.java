package Greedy;

public class MergeTriplets {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int start = 0;
        int len = triplets.length;
        for(int i = 0; i < len; i++){
            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]){
                start = i;
                break;
            }
        }
        if(start == len){
            return false;
        }
        int[] res = triplets[start];
        for(int i = start + 1; i< len; i++ ){
            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]){
                res[0] = Math.max(res[0], triplets[i][0]);
                res[1] = Math.max(res[1], triplets[i][1]);
                res[2] = Math.max(res[2], triplets[i][2]);
            }
            if(res[0] == target[0] && res[1] == target[1] && res[2] == target[2]){
                return true;
            }
        }
        return res[0] == target[0] && res[1] == target[1] && res[2] == target[2];
    }

    public static void main(String[] args) {
        MergeTriplets mt = new MergeTriplets();
        System.out.println(mt.mergeTriplets(new int[][]{{2, 5, 3}, {2, 3, 4}, {1, 2, 5},{5, 2, 3}}, new int[]{5, 5, 5}));
    }

}
