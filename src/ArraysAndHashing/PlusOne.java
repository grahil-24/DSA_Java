package ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        List<Integer> list = new ArrayList<>(digits.length + 1);
        boolean carry = false;
        int sum = digits[length - 1] + 1;
        if (sum >= 10) {
            sum = sum - 10;
            carry = true;
        }
        list.add(sum);
        for (int i = length - 2; i >= 0; i--) {
            int sum1;
            if (carry) {
                sum1 = digits[i] + 1;
                if (sum1 >= 10) {
                    sum1 = sum1 - 10;
                } else {
                    carry = false;
                }
                list.add(sum1);
                continue;
            }
            list.add(digits[i]);
        }
        if (carry) {
            list.add(1);
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(arr.length - 1 - i); // Reversing the list
        }

        return arr;
    }


    public static void main(String[] args) {

    }
}
