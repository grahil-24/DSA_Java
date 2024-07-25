package TwoDimDP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        Set<List<Integer>> visited = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }

        int max = 1;

        for(int i = 0; i< rows; i++){
            for(int j = 0; j<cols; j++){
                if(dp[i][j] != -1){
                    continue;
                }else{
                    int res = helper(visited, i, j, dp, -1, matrix);
                    if(res > max){
                        max = res;
                    }
                }
            }
        }
        return max;
    }

    public int helper( Set<List<Integer>> visited, int x, int y, int[][] dp, int prev, int[][] matrix){
        if(x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0){
            return 0;
        }
        if(visited.contains(Arrays.asList(x, y))){
            return 0;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        if(matrix[x][y] <= prev){
            return 0;
        }
        int left = helper(visited, x, y-1, dp, matrix[x][y], matrix);
        int right = helper(visited, x, y+1, dp, matrix[x][y], matrix);
        int up = helper(visited, x-1, y,dp, matrix[x][y], matrix);
        int down = helper(visited, x+1, y,dp, matrix[x][y], matrix);
        visited.remove(Arrays.asList(x, y));
        int res = Math.max(Math.max(Math.max(left, right), up), down) + 1;
        dp[x][y] = res;
        return res;
    }


    public static void main(String[] args) {
        LongestIncreasingPath lip = new LongestIncreasingPath();
        System.out.println(lip.longestIncreasingPath(new int[][]{
                        {0,1,2,3,4,5,6,7,8,9},
                        {19,18,17,16,15,14,13,12,11,10},
                        {20,21,22,23,24,25,26,27,28,29},
                        {39,38,37,36,35,34,33,32,31,30},
                        {40,41,42,43,44,45,46,47,48,49},
                        {59,58,57,56,55,54,53,52,51,50},
                        {60,61,62,63,64,65,66,67,68,69},
                        {79,78,77,76,75,74,73,72,71,70},
                        {80,81,82,83,84,85,86,87,88,89},
                        {99,98,97,96,95,94,93,92,91,90},
                        {100,101,102,103,104,105,106,107,108,109},
                        {119,118,117,116,115,114,113,112,111,110},
                        {120,121,122,123,124,125,126,127,128,129},
                        {139,138,137,136,135,134,133,132,131,130},
                        {0,0,0,0,0,0,0,0,0,0}
                }
        ));
    }


}

