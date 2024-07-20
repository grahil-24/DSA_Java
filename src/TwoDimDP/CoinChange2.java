package TwoDimDP;

public class CoinChange2 {

    public int change(int amount, int[] coins) {
        return helper(0, amount, coins);
    }

    public int helper(int index, int amount, int[] coins) {
        if(index == coins.length || amount < 0) return 0;

        if(amount == 0){
            return 1;
        }
        int res = 0;
        for(int i = index; i < coins.length; i++){
            res += helper(i, amount - coins[i], coins);
        }

        return res;
    }

    public static void main(String[] args) {
        CoinChange2 cc2 = new CoinChange2();
        System.out.println(cc2.change(5, new int[]{1, 2, 5}));
    }
}
