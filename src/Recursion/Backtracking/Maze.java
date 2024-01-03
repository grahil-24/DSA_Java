package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    static int count(int r, int c){
        if (r == 1 | c == 1){
            return 1;
        }

        int left = count(r-1, c);
        int right = count(r, c-1);
        return left+right;
    }

    static void path(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r > 1){
            path(p+"V", r-1, c);
        }
        if(c > 1){
            path(p+"H", r, c-1);
        }
        if(r > 1 && c > 1){
            path(p+"D", r-1, c-1);
        }

    }


    //cant use cell (2, 2)
    static void pathRestriction(String p, boolean[][] maze,int r, int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r < maze.length-1){
            pathRestriction(p+"V", maze,r+1, c);
        }
        if(c < maze[0].length-1){
            pathRestriction(p+"H", maze, r, c+1);
        }
        if(r <maze.length-1 && c < maze[0].length-1){
            pathRestriction(p+"D", maze,r+1, c+1);
        }

    }

    static List<String> pathList(String p, int r, int c){
        if(r == 1 && c == 1){
            List<String> tmp = new ArrayList<>();
            tmp.add(p);
            return tmp;
        }
        List<String> res = new ArrayList<>();
        if(r > 1){
            res.addAll(pathList(p+"V", r-1, c));
        }
        if(c > 1){
            res.addAll(pathList(p+"H", r, c-1));
        }
        if(r > 1 && c > 1){
            res.addAll(pathList(p+"D", r-1, c-1));
        }
        return  res;
    }

    public static void main(String[] args) {

        boolean[][] maze = {{true, true, true},
                {true, false, true},
                {true, true, true}};
//        System.out.println(count(3, 3));
//        System.out.println(pathList("", 3, 3));
//        path("", 3, 3);
        pathRestriction("", maze, 0, 0);
    }
}
