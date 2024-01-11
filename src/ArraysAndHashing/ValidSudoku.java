package ArraysAndHashing;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j  = 0; j< 9; j++){
                if(isSafe(board, i, j)){
                    continue;
                }else if(board[i][j] == '.'){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][] board, int i, int j){
        //check the column
        for(int k =0; k< 9; k++){
            if(k == j){
                continue;
            }
            if(board[i][j] == board[i][k]){
                return false;
            }
        }

        //check the row
        for(int k = 0; k < 9; k++){
            if(k == i){
                continue;
            }
            if(board[i][j] == board[k][j]){
                return false;
            }
        }
        int row = i - i % 3;
        int col = j - j % 3;
        for(int k = row; k < row + 3; k++){
            for(int l = col; l < col + 3; l++){
                if(k == i &&  l == j){
                    continue;
                }
                if(board[k][l] == board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
