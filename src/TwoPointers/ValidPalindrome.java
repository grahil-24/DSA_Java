package TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s){
        boolean isPalindrome = true;
        int length = s.length();
        int i = 0;
        int j = length - 1;
        s = s.toLowerCase();
        while(i <= j){
            char charI = s.charAt(i);
            char charJ = s.charAt(j);
            if (!((charI >= 'a' && charI <= 'z') || (charI >= '0' && charI <= '9'))) {
                i++;
                continue;
            }

            if (!((charJ >= 'a' && charJ <= 'z') || (charJ >= '0' && charJ <= '9'))) {
                j--;
                continue;
            }
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
                continue;
            }
            isPalindrome = false;
            break;
        }
        return isPalindrome;
    }


    public static void main(String[] args) {
            ValidPalindrome vp = new ValidPalindrome();
            System.out.println(vp.isPalindrome("0P"));
    }
}
