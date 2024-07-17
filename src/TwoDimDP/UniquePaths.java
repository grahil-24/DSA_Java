package TwoDimDP;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        memoization(0, 0, m, n, cache);
        return cache[0][0];
    }

    public int memoization(int i, int j, int m, int n,int[][] cache) {
        if(i == m || j == n){
            return 0;
        }
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        cache[i][j] = memoization(i, j + 1, m, n, cache) + memoization(i , j + 1, m, n, cache);
        return cache[i][j];
    }

    public static void main(String[] args) {

    }
}
