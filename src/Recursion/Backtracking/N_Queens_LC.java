package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_LC {

    private boolean isValid(char[][] board, int x, int y) {

        if(x == 0){
            return true;
        }
        int x_tmp = x;
        while(x_tmp>0){
            x_tmp--;
            if(board[x_tmp][y] == 'Q'){
                return false;
            }
        }
        int y_tmp = y;
        while(y_tmp>0){
            y_tmp--;
            if(board[x][y_tmp] == 'Q'){
                return false;
            }
        }

        x_tmp = x;
        y_tmp = y;
        while(x_tmp > 0 && y_tmp > 0){
            x_tmp--;
            y_tmp--;

            if(board[x_tmp][y_tmp] == 'Q'){
                return false;
            }
        }

        x_tmp = x;
        y_tmp = y;
        while(x_tmp > 0 && y_tmp < board.length-1){
            x_tmp--;
            y_tmp++;

            if(board[x_tmp][y_tmp] == 'Q'){
                return false;
            }
        }

        return true;
    }

    private void backtrack(char[][] board, int row, int col, List<List<String>> res){
        if(row >= board.length){
            copyResToArray(board, res);
            return;
        }

        for(int i = 0; i<board.length; i++){
            if(isValid(board, row, i)){
                board[row][i] = 'Q';
                backtrack(board, row+1, i, res);
                board[row][i] = '.';
            }
        }
    }

    private void copyResToArray(char[][] board, List<List<String>> res){
        StringBuilder sb;
        List<String> matrix = new ArrayList<>();
        for(int i = 0; i<board.length; i++){
            sb = new StringBuilder();
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == 'Q'){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            matrix.add(sb.toString());

        }
        res.add(new ArrayList<>(matrix));      
    }


    private List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, 0, res);
        return res;
    }

    public static void main(String[] args) {
        N_Queens_LC nq = new N_Queens_LC();
        List<List<String>> res = nq.solveNQueens(4);
        System.out.println(res);
    }

}
