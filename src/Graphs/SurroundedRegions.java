package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurroundedRegions {

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];
        for(int j = 0; j<cols; j++){
            if(visited[0][j] == 0 && board[0][j]!='X' && board[0][j] != 'Y'){
                isSinked(board, 0, j,visited);
            }
        }
        for(int j = 0; j<cols; j++){
            if(visited[rows-1][j] == 0 && board[rows-1][j]!='X' && board[rows-1][j] != 'Y'){
                isSinked(board, rows-1, j,visited);
            }
        }
        for(int j = 0; j<rows; j++){
            if(visited[j][0] == 0 && board[j][0]!='X' && board[j][0] != 'Y'){
                isSinked(board, j, 0,visited);
            }
        }
        for(int j = 0; j<rows; j++){
            if(visited[j][cols-1] == 0 && board[j][cols-1]!='X' && board[j][cols-1] != 'Y'){
                isSinked(board, j, cols-1,visited);
            }
        }

        for(int i =0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    public  void isSinked(char[][] board, int row, int col, int[][] visited){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] == 1 || board[row][col] == 'X'){
            return;
        }

        visited[row][col] = 1;
        isSinked(board, row+1, col,  visited);
         isSinked(board, row-1, col,  visited);
        isSinked(board, row, col+1,  visited);
        isSinked(board, row, col-1,  visited);
        board[row][col] = 'Y';
    }

    public void sink(List<List<Integer>> indexes, char[][] board){
        for(List<Integer> index: indexes) {
            board[index.get(0)][index.get(1)] = 'X';
        }
    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}
        };
        sr.solve(board);
        System.out.println();
    }
}
