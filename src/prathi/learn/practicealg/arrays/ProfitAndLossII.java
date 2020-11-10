package prathi.learn.practicealg.arrays;

public class ProfitAndLossII {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        for (int i=0;i<prices.length -1; i++) {
            if (prices[i+1] > prices[i]) {
                result += prices[i+1] - prices[i];
            }
        }

        return result;

    }
}
