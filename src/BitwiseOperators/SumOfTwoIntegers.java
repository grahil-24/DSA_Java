package BitwiseOperators;

public class SumOfTwoIntegers {


    public int getSum(int a, int b) {
        int res = 0;
        boolean carry = false;
        for(int i  =0; i<32; i++){
            int dig_a = a & 1;
            int dig_b = b & 1;
            int sum = dig_a + dig_b;
            if(sum == 0){
                if(carry){
                    carry = false;
                    res = res | 1;
                }
            }else if(sum == 1){
                if(!carry){
                    res = res | 1;
                }

            }else{
                if(carry){
                    res = res | 1;
                }else{
                    carry = true;
                }
            }
            a = a >> 1;
            b = b >> 1;
            res = Integer.rotateRight(res, 1);
        }

        return res;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers sti = new SumOfTwoIntegers();
        System.out.println(sti.getSum(2, 3));
    }

}
