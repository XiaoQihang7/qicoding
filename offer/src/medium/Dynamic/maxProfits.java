package medium.Dynamic;

public class maxProfits {
    public static void main(String[] args) {
        maxProfits maxProfits = new maxProfits();
        System.out.println(maxProfits.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * offer63、股票的最大利润
     * @param prices 股票价格
     * @return 利润
     */
    public int maxProfit(int[] prices) {
        int cost=Integer.MAX_VALUE,profit=0;
        for (int price : prices){
            cost= Math.min(cost,price);
            profit= Math.max(profit,price-cost);
        }
        return profit;
    }
}
