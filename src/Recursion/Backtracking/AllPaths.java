package Recursion.Backtracking;

import java.util.Arrays;

public class AllPaths {


    static void path(String p, boolean[][] maze, int r, int c){
        if(r== maze.length -1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;

        if(c < maze[0].length-1){
            path(p+"R", maze, r, c+1);
        }
        if(r < maze.length-1){
            path(p+"D", maze, r+1, c);
        }
        if(c > 0){
            path(p+"L", maze, r, c-1);
        }
        if(r > 0){
            path(p+"U", maze, r-1, c);
        }
        maze[r][c] = true;
    }

    static void printPath(String p, boolean[][] maze, int r, int c, int[][] path, int step){
        if(r== maze.length -1 && c == maze[0].length-1){
            path[r][c] = step;
            System.out.println(p);
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if(c < maze[0].length-1){
            printPath(p+"R", maze, r, c+1, path, step+1);
        }
        if(r < maze.length-1){
            printPath(p+"D", maze, r+1, c, path, step+1);
        }
        if(c > 0){
            printPath(p+"L", maze, r, c-1, path, step+1);
        }
        if(r > 0){
            printPath(p+"U", maze, r-1, c, path, step+1);
        }
        maze[r][c] = true;
        path[r][c] = 0;
    }
    public static void main(String[] args) {
        boolean[][] maze = {{true, true, true},
                {true, true, true},
                {true, true, true}};

        int[][] path = {{0, 0, 0},
                {0, 0,0},
                {0, 0, 0}};

        printPath("", maze, 0, 0, path, 1);
    }
}
