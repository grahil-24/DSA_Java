package TwoDimDP;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, 0, 0);
    }

    public int helper(String text1, String text2, int index1, int index2) {
        if(index1 == text1.length() || index2 == text2.length()){
            return 0;
        }

        if(text1.charAt(index1) == text2.charAt(index2)){
            return 1 + helper(text1, text2, index1 + 1, index2 + 1);
        }else{
            return Math.max(helper(text1, text2, index1 + 1, index2), helper(text1, text2, index1, index2 + 1));
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("abc", "def"));
    }
}
