class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE,ans=0;

        for(int price:prices){
            minVal = Math.min(price,minVal);
            ans = Math.max(ans,price-minVal);
        }
        return ans;
    }
}
