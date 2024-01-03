//package Recursion.Backtracking;
//
//public class SudokuSolverChar {
//
//    static boolean solve(char[][] board){
//        int n = board.length;
//        int row = -1;
//        int col = -1;
//
//        boolean emptyLeft = true;
//
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                if(board[i][j] == '.'){
//                    row = i;
//                    col = j;
//                    emptyLeft = false;
//                    break;
//                }
//            }
//            if(!emptyLeft){
//                break;
//            }
//        }
//        //when sudoku solved
//        if(emptyLeft){
//            return true;
//        }
//
//        //backtracking
//        for(char i='1'; i<='9'; i++){
//            if(isSafe(board, row, col, i)){
//                board[row][col] = i;
//                if(solve(board)){
//                    return true;
//                }else{
//                    board[row][col] = '.';
//                }
//            }
//        }
//        return false;
//    }
//
//    static void display(char[][]  board){
//        for(char[] row: board){
//            for(char num: row){
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    static boolean isSafe(char[][] board, int row, int col, char num){
//        //check row
//        for(int i = 0; i< board.length; i++){
//            if(board[i][col] == num){
//                return false;
//            }
//        }
//
//        //check column;
//        for(int i=0; i< board.length; i++){
//            if(board[row][i] == num){
//                return false;
//            }
//        }
//
//        //check block
//        int sqrt = (int)Math.sqrt(board.length);
//        int start_row = row - row % sqrt;
//        int start_col = col - col % sqrt;
//
//        for(int i = start_row; i<start_row + sqrt; i++){
//            for(int j = start_col; j<start_col + sqrt; j++){
//                if(board[i][j] == num){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        char[][] board = {{"5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]];
//
//        if(solve(board)){
//            display(board);
//        }
//    }
//}
