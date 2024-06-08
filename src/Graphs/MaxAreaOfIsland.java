package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {


    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int area = findArea(grid, i, j);
                    if(area > max_area){
                        max_area = area;
                    }
                }
            }
        }
        return  max_area;
    }

    public int findArea(int[][] grid, int row, int col){
        if(row >= grid.length || row < 0 || col >= grid[row].length || col < 0 || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;
        int area = 1;
        area += findArea(grid, row+1, col);
        area += findArea(grid, row-1, col);
        area += findArea(grid, row, col+1);
        area += findArea(grid, row, col-1);
        return area;
    }


}
