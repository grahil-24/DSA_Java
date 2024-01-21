package Stack;

import javax.lang.model.type.MirroredTypeException;
import java.util.Arrays;
import java.util.Stack;


public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Pair> stack = new Stack<>();
        for(int i = 0; i<temperatures.length; i++){
            while(!stack.empty() && temperatures[i] > stack.peek().key){
                int index = stack.pop().val;
                res[index] = i - index;
            }
            stack.push(new Pair(temperatures[i], i));
        }
        if(!stack.empty()){
            while(!stack.empty()){
                int index = stack.pop().val;
                res[index] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DailyTemperatures.dailyTemperatures(new int[]{30, 60, 90})));
    }
}


