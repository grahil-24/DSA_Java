package TwoDimDP;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int str1_len  = text1.length();
        int str2_len = text2.length();
        int[][] dp = new int[str1_len + 1][str2_len + 1];
        for(int i = 1; i <= str1_len; i++) {
            for(int j = 1; j <= str2_len; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[str1_len][str2_len];

        int[][] cache = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++){
            for(int j = 0; j < text2.length(); j++){
                cache[i][j] = -1;
            }
        }

        return helper(text1, text2, 0, 0, cache);
    }

    public int helper(String text1, String text2, int index1, int index2, int[][] cache) {
        if (index1 == text1.length() || index2 == text2.length()) {
            return 0;
        }

        if (cache[index1][index2] != -1) {
            return cache[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            cache[index1][index2] = 1 + helper(text1, text2, index1 + 1, index2 + 1, cache);
        } else {
            cache[index1][index2] =  Math.max(
                helper(text1, text2, index1 + 1, index2, cache),
                helper(text1, text2, index1, index2 + 1, cache)
            );
        }
        return cache[index1][index2];
    }



    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("abc", "def"));
    }
}
