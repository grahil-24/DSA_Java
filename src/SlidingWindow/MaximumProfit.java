package SlidingWindow;

public class MaximumProfit {

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int i = 0;
        int maxProfit = 0;
        while(i < length){
            int j = i+1;
            int max = -1;
            while(j < length){
                if(prices[j] < prices[i]){
                    break;
                }else{
                    if(prices[j] > max){
                        max = prices[j];
                    }
                }
                j++;
            }
            if(max - prices[i] > maxProfit){
                maxProfit = max - prices[i];
            }
            i = j;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(MaximumProfit.maxProfit(new int[]{10, 2, 3, 4, 3, 100, 9, 101}));
    }
}
