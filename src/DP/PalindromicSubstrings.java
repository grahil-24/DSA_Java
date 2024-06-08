package DP;

public class PalindromicSubstrings {


    public int countSubstrings(String s) {
        int res = 0;
        int len = s.length();
        if(len == 0){
            return res;
        }
        if(len == 1){
            return 1;
        }
        for(int i = 0; i<len; i++){
            int l = i;
            int r = i;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                res++;
            }
            l = i;
            r = i+1;
            while(l>=0 && r < len && s.charAt(l)== s.charAt(r)){
                l--;
                r++;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {



    }
}
