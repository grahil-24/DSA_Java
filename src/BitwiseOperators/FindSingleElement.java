package BitwiseOperators;

public class FindSingleElement {

    public static int findSingleEle(int[] arr){
        int res= arr[0];
        for(int i  = 0; i<arr.length-1; i++){
            res = res^arr[i+1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(FindSingleElement.findSingleEle(arr));
    }
}
