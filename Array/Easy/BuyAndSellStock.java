public class BuyAndSellStock {
    public int maxProfit(int[] prices){
int mini = prices[0];
int maxProfit =0;
int n = prices.length;
for( int i =0 ; i< n;i++){
    int cost = prices[i]- mini;
    maxProfit = Math.max(maxProfit,cost);
    mini = Math.min(mini,prices[i]);
}
return maxProfit;
    }
    public static void main( String[] args){
BuyAndSellStock obj = new BuyAndSellStock();
int[] prices = {7,1,5,3,6,4};
int result = obj.maxProfit(prices);
System.out.println("MAximum profit =" + result);
    }
}
