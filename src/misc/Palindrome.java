package misc;

public class Palindrome {

    public boolean checkForPalindrome(String str){
        int start = 0;
        int end = str.length()-1;

        while(start < end){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.checkForPalindrome("HiefiH"));
    }
}
