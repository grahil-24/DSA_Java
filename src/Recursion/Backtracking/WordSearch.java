package Recursion.Backtracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for(int row = 0; row<board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(dfs(board, row, col, visited, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, int[][] visited, int index, String word){
        if(index == word.length()){
            return true;
        }
        if(row >= board.length || row < 0 || col < 0 || col >= board[row].length || visited[row][col] == 1 ||
        board[row][col] != word.charAt(index)){
            return false;
        }

        visited[row][col] = 1;
        if(dfs(board, row+1, col, visited, index+1, word) || dfs(board, row, col+1, visited,
                index+1, word) || dfs(board, row-1, col, visited, index+1, word) ||
                dfs(board, row, col-1, visited, index+1, word) ){
            return true;
        }
        visited[row][col] = 0;
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D','E','E'}};
        String word = "ABCCED";
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, word));
    }
}
