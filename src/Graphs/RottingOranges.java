package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] rotten = new int[rows][cols];
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                    rotten[i][j] = 2;
                }
            }
        }

        while(!queue.isEmpty()){
            List<int[]> list = new ArrayList<>();
            while(!queue.isEmpty()){
                int[] toq = queue.poll();
                list.add(toq);
            }
            appendChild(list, queue, grid, rows, cols);
            if(!queue.isEmpty()){
                minutes++;
            }

        }

        for(int i = 0; i< rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return minutes-1;
    }

    public void appendChild(List<int[]> list, Queue<int[]> queue, int[][] grid, int rows, int cols){
        for(int[] toq: list){
            if(toq[0]+1 < rows && grid[toq[0]+1][toq[1]] == 1){
                grid[toq[0]+1][toq[1]] = 2;
                queue.offer(new int[]{toq[0]+1, toq[1]});
            }
            if(toq[0]-1 >= 0 && grid[toq[0]-1][toq[1]] == 1){
                grid[toq[0]-1][toq[1]] = 2;
                queue.offer(new int[]{toq[0]-1, toq[1]});
            }
            if(toq[1]+1 < cols && grid[toq[0]][toq[1]+1] == 1){
                grid[toq[0]][toq[1]+1] = 2;
                queue.offer(new int[]{toq[0], toq[1]+1});
            }
            if(toq[1]-1 >= 0 && grid[toq[0]][toq[1]-1] == 1){
                grid[toq[0]][toq[1]-1] = 2;
                queue.offer(new int[]{toq[0], toq[1]-1});
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid  = {{0,2}};
        RottingOranges ro = new RottingOranges();
        System.out.println(ro.orangesRotting(grid));
    }

}
