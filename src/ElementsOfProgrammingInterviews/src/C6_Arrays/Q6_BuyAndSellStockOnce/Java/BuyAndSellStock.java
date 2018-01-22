package ElementsOfProgrammingInterviews.src.C6_Arrays.Q6_BuyAndSellStockOnce.Java;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStock {
    public static double computeMaxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
        for (Double price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }

    // O(n^2) checking answer.
    private static double checkAns(List<Double> prices) {
        double cap = 0;
        for (int i = 1; i < prices.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                cap = Math.max(cap, prices.get(i) - prices.get(j));
            }
        }
        return cap;
    }

    public static void main(String[] args){
        List<Double> a = new ArrayList<>();
        a.add(310.0);
        a.add(315.0);
        a.add(275.0);
        a.add(295.0);
        a.add(260.0);
        a.add(270.0);
        a.add(290.0);
        a.add(230.0);
        a.add(255.0);
        a.add(250.0);
        System.out.println(computeMaxProfit(a));
        assert(Double.compare(checkAns(a), computeMaxProfit(a)) == 0);
    }
}
