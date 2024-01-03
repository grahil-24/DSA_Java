package Recursion.Backtracking;

public class SudokuSolver {

    static boolean solve(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(!emptyLeft){
                break;
            }
        }
        //when sudoku solved
        if(emptyLeft){
            return true;
        }

        //backtracking
        for(int i=1; i<=9; i++){
            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                if(solve(board)){
                    return true;
                }else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static void display(int[][]  board){
        for(int[] row: board){
            for(int num: row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        //check row
        for(int i = 0; i< board.length; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        //check column;
        for(int i=0; i< board.length; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        //check block
        int sqrt = (int)Math.sqrt(board.length);
        int start_row = row - row % sqrt;
        int start_col = col - col % sqrt;

        for(int i = start_row; i<start_row + sqrt; i++){
            for(int j = start_col; j<start_col + sqrt; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if(solve(board)){
            display(board);
        }
    }
}
