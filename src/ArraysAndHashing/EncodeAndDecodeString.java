package ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String i: strs){
            str.append(i);
            str.append("#");
        }

        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> ans= new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '#'){
                ans.add(s.toString());
                s.setLength(0);
            }else{
                s.append(str.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EncodeAndDecodeString e = new EncodeAndDecodeString();
        List<String> list = new ArrayList<>();
        list.add("we");
        list.add("say");
        list.add(":");
        list.add("yes");
        list.add("!@#$%^&*()");
        System.out.println(e.decode(e.encode(list)));
    }
}
