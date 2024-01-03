package Recursion;

public class SkipCharacter {

    static void skipCharacter(String string, String up){
        if(up.isEmpty()){
            System.out.println();
            return;
        }

        char c = up.charAt(0);
        if(c == 'a'){
            skipCharacter(string, up);
        }else{
            skipCharacter(string + up, up);
        }
    }

    public static void main(String[] args) {
            SkipCharacter.skipCharacter("", "rahil");
    }
}
