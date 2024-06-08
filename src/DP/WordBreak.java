package DP;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            int k = i;
            for(int j = 0; j<wordDict.size(); j++ ){
                if(dp[k] == 1){
                    break;
                }
                String word = wordDict.get(j);
                int len = word.length();
                if(len + k <= s.length()){
                    if(s.substring(k, k+len).equals(word)){
                        dp[k] = dp[k  + len];
                    }else{
                        continue;
                    }
                }else{
                    continue;
                }
            }
        }
        return dp[0] == 1;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");

        System.out.println(wb.wordBreak("cars", wordDict));
    }
}
