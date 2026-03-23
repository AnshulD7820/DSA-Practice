public class BestTimeToBuyAndSellStocks {

    // LeetCode Problem : 121. Best Time to Buy and Sell Stocks
    // Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock

    // GFG Problem : Stock Buy and Sell – Max one Transaction Allowed
    // Link : https://www.geeksforgeeks.org/problems/buy-stock-2/1

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        System.out.println("Brute Force Approach : " + buyAndSellStocksBrute(arr));
        System.out.println("Optimal Approach : " + buyAndSellStocksOptimal(arr));
    }

    // Brute Force Approach :
    static int buyAndSellStocksBrute(int[] arr){
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j ++){
                int profit = arr[j] - arr[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
    // Time Complexity : O(N * N)
    // Space Complexity : O(1)

    // Optimal Approach:
    static int buyAndSellStocksOptimal(int[] arr){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : arr){
            if(price < minPrice)
                minPrice = price;
            else if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }
        return maxProfit;
    }
    // Time Complexity : O(N)
    // Space Complexity : O(1)

}
