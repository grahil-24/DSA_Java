package Stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        return generateParenthesis(n, n, "");
    }

    public static List<String> generateParenthesis(int ob, int cb, String str) {
        List<String> strlist = new ArrayList<>();
        if(ob == 0 && cb == 0){
            strlist.add(str);
            return strlist;
        }

        if (ob > 0) {
            List<String> openCombinations = generateParenthesis(ob - 1, cb, str.concat("("));
            strlist.addAll(openCombinations);
        }

        // Recursively generate combinations for close brackets
        if (cb > ob) {
            List<String> closeCombinations = generateParenthesis(ob, cb - 1, str.concat(")"));
            strlist.addAll(closeCombinations);
        }

        return strlist;
    }

    public static void main(String[] args) {
        System.out.println(GenerateParenthesis.generateParenthesis(3));
    }
}
