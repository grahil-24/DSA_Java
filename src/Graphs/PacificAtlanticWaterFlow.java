package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];


        for(int i = 0; i < rows; i++){
            //pacific
            dfs(i, 0, pacific, Integer.MIN_VALUE, heights);
            //atlantic
            dfs(i, cols-1, atlantic, Integer.MIN_VALUE, heights);
        }
        for(int i = 0; i < cols; i++){
            //pacific
            dfs(0, i, pacific, Integer.MIN_VALUE, heights);
            //atlantic
            dfs(rows-1, i, atlantic, Integer.MIN_VALUE, heights);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return res;

    }

    public void dfs(int row, int col, boolean[][] ocean, int prev, int[][] heights){
        if(row < 0 || row >= ocean.length || col < 0 || col > ocean[0].length || ocean[row][col] || prev > heights[row][col]){
            return;
        }
        ocean[row][col] = true;
        dfs(row+1, col, ocean, heights[row][col], heights);
        dfs(row-1, col, ocean, heights[row][col], heights);
        dfs(row, col+1, ocean, heights[row][col], heights);
        dfs(row, col-1, ocean, heights[row][col], heights);
    }
}
