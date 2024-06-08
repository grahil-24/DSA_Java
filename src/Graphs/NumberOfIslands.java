package Graphs;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int numOfIslands = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    getIsland(grid, visited, i, j);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;

    }

    public void getIsland(char[][] grid, int[][] visited, int row, int col){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || visited[row][col] == 1){
            return;
        }

        visited[row][col] = 1;
        if(grid[row][col] == '0'){
            return;
        }
//        getIsland(grid, visited, row-1, col);
        getIsland(grid, visited, row+1, col);
//        getIsland(grid, visited, row, col-1);
        getIsland(grid, visited, row, col+1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}
        ,{'0', '0', '0', '1', '1'}};

        NumberOfIslands noi = new NumberOfIslands();
        System.out.println(noi.numIslands(grid));
    }

}
