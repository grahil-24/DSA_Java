package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class HalfStringsAreAlike {

    public boolean halvesAreAlike(String s) {
        int firstHalf =0;
        int secondHalf = 0;
        int index2 = s.length()/2;

        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');

        for(int i = 0; i< index2; i++){
            if(vowelSet.contains(s.charAt(i))){
                firstHalf++;
            }
            if(vowelSet.contains(s.charAt(index2))){
                secondHalf++;
            }
            index2++;
        }

        return firstHalf == secondHalf;
    }

    public static void main(String[] args) {

    }
}
