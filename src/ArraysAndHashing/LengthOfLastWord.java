package ArraysAndHashing;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int length = 0;
        int size = s.length();
        boolean encounteredWord = false;
        int i;
        for(i = size-1; i>=0; i--){
            if(s.charAt(i) != ' '){
                encounteredWord = true;
                break;
            }
        }
        while(encounteredWord && i>=0){
            if(s.charAt(i) == ' '){
                encounteredWord = false;
            }else{
                length++;
                i--;
            }
        }

        return length;
    }


    public static void main(String[] args) {
        System.out.println(LengthOfLastWord.lengthOfLastWord("s "));
    }
}
