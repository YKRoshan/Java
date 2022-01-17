package com.practice.day1;

/*
Solution 1(Brute Force):
1.
2.
3.

Time Complexity: O()
Space Complexity: O()

Solution 2(Better):
1.
2.
3.
Time Complexity: O()
Space Complexity: O()

Solution 3(Optimal):
1.
2.
3.
Time Complexity: O()
Space Complexity: O()

*/
public class StockBuyAndSell {

    //My Solution
    public int maxProfit1(int[] prices) {
        int max = prices[prices.length - 1];
        int min;
        int res = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                min = prices[i];
                res = Math.max((max - min), res);
            }
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
