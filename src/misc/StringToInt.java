package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringToInt {

    public int myAtoi(String s){
        Map<Character, Integer> digits  = new HashMap<>() {{
            put('0', 0);
            put('1', 1);
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
        }};
        double res = 0;
        int length = s.length();
        boolean pos = true;

        if(length == 1){
            return digits.get(s.charAt(0));
        }else{
            if(s.charAt(0) == '-'){
                pos = false;
                s = s.split("-")[1];
                length--;
            }
            for(int i = 0; i<length; i++){
                int digit = digits.get(s.charAt(i));
                res = res + Math.pow(10, length - i - 1) * digit;
            }
        }
        if(pos){
            return (int)res;
        }else{
            res = 0 - res;
            return (int) res;
        }

    }

    public static void main(String[] args) {
        StringToInt sti = new StringToInt();
        System.out.println(sti.myAtoi("-5"));
    }
}
