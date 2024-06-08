package SlidingWindow;

public class LongestRepeatingCharRepl {

    public static int characterReplacement(String s, int k) {
        int[] arr = new int[]{0, 0};
        int length = s.length();
        int i = 0;
        int maxLen = 0;
        while(i < length){
            int j = i;
            while(j < length){
                if(s.charAt(j) == 'A'){
                    arr[0]++;
                }else{
                    arr[1]++;
                }
                if(Math.min(arr[0], arr[1]) > k){
                    break;
                }
                j++;
            }
            if(j - i > maxLen){
                maxLen = j - i;
            }
            i = j;
            arr[0] = 0;
            arr[1] = 0;
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(LongestRepeatingCharRepl.characterReplacement("ABBB", 0));
    }
}
