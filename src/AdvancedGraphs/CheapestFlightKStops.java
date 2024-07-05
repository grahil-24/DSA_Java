package AdvancedGraphs;

import java.util.*;

public class CheapestFlightKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for(int i = 0; i<=k; i++){
            int[] tmp_prices = prices.clone();
            for(int[] flight: flights){
                if(prices[flight[0]] == Integer.MAX_VALUE){
                    continue;
                }
                if(prices[flight[0]] + flight[2] < tmp_prices[flight[1]]){
                    tmp_prices[flight[1]] = prices[flight[0]] + flight[2];
                }
            }
            prices = tmp_prices;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }


    public static void main(String[] args) {
        CheapestFlightKStops c = new CheapestFlightKStops();
        int[][] array = {
                {0, 3, 3},
                {3, 4, 3},
                {4, 1, 3},
                {0, 5, 1},
                {5, 1, 100},
                {0, 6, 2},
                {6, 1, 100},
                {0, 7, 1},
                {7, 8, 1},
                {8, 9, 1},
                {9, 1, 1},
                {1, 10, 1},
                {10, 2, 1},
                {1, 2, 100}
        };
        System.out.println(c.findCheapestPrice(4,array, 0, 2, 4));
    }
}
