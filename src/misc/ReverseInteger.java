package misc;

public class ReverseInteger {

    public int reverse(int x){
        boolean positive = true;
        int revNumber = 0;
        int remainder;

        if(x < 0){
            positive = false;
            x = Math.abs(x);
        }
        while(x!= 0){
            remainder = x % 10;
            revNumber = revNumber * 10 + remainder;
            x = x/10;
        }
        if(!positive){
            revNumber = -revNumber;
        }

        return revNumber;
    }

    public static void main(String[] args) {

    }
}
