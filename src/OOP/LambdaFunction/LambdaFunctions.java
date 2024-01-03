package OOP.LambdaFunction;

import java.util.ArrayList;
import java.util.function.Consumer;

// lambda functions are one line or in-line functions
public class LambdaFunctions {

    int sum(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<5; i++){
            arr.add(i+1);
        }

        arr.forEach((item) -> {
            System.out.println(item*2);
        });

        Consumer<Integer> fun = (item) -> System.out.println(item*2);
        arr.forEach(fun);

        Operation sum = (a, b) -> a + b;
        Operation prod = (a, b) -> a * b;

        LambdaFunctions fun2 = new LambdaFunctions();
        int res  = fun2.operate(1, 2, sum);
        System.out.println(res);
    }

    private int operate(int a, int b, Operation operation){
        return operation.operation(a, b);
    }

}

interface Operation{

    int operation(int a, int b);
}
