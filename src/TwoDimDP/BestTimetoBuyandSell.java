package TwoDimDP;

import java.util.HashMap;
import java.util.Map;

public class BestTimetoBuyandSell {

    public int maxProfit(int[] prices) {
        Map<String, Integer> cache = new HashMap<>();
        return helper(0, prices, true, cache);
    }


    public int helper(int index, int[] prices, boolean buying, Map<String, Integer> cache){

        if(index >= prices.length) return 0;
        String str = STR."\{index}-\{buying}";
        if(cache.containsKey(str)) return cache.get(str);
        int cooldown = helper(index+1, prices, buying, cache);
        int buy_sell = 0;
        if(buying){
            buy_sell = helper(index + 1, prices, !buying, cache) - prices[index];
        }else{
            buy_sell = helper(index + 2, prices, !buying, cache) + prices[index];
        }

        int res = Math.max(buy_sell, cooldown);
        cache.put(str, res);
        return res;
    }


    public static void main(String[] args) {
        BestTimetoBuyandSell bestTimetoBuyandSell = new BestTimetoBuyandSell();
        System.out.println(bestTimetoBuyandSell.maxProfit(new int[]{1}));
    }
}
