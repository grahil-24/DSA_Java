package TwoDimDP;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
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
