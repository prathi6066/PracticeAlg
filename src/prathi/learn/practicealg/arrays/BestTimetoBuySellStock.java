package prathi.learn.practicealg.arrays;

public class BestTimetoBuySellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public static  int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int i=0;i<prices.length;i++) {
            if (minPrice > prices[i])
                minPrice = prices[i];
            else
                profit = Math.max(profit, prices[i]-minPrice);
        }

        return profit;

    }
}
