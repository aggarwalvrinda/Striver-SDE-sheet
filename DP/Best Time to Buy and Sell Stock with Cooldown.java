//leetcode link-- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/1331466192/


//Approach-1 (Recursion+Memoization) TC:O(n)
class Solution {
    public int solve(int[] prices, int n , int day, int buy, int[][]dp){
        if(day>=n){
            return 0;
        }
        //step2
        if (dp[day][buy] != -1) {
            return dp[day][buy];
        }
        int profit =0;
        if(buy==1){
            //buy case
            int take = solve(prices,n, day+1, 0,dp) -prices[day];
            int notTake = solve(prices,n, day+1,1,dp);
            profit = Math.max(take, notTake);
        }else{
            //sell Case
            int sell = solve(prices,n,day+2, 1,dp) +prices[day];
            int notSell = solve(prices,n, day+1, 0,dp);
            profit = Math.max(profit,Math.max(sell,notSell));
        }
        return dp[day][buy]=profit ;

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //step1
        int dp[][] = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(prices, n , 0, 1,dp);
    }
}

//bottom up approach 

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0|| n==1){
            return 0;
        }
        int dp[]= new int[n];
        dp[0]=0;
        dp[1]=Math.max(prices[1]-prices[0],0);

        for(int i=2;i<n;i++){
            dp[i]= dp[i-1];
            for(int j=0;j<=i-1;j++){
                int prevProfit = j>=2 ? dp[j-2]:0;
                dp[i]= Math.max((prices[i]-prices[j])+prevProfit, dp[i]);
            }
        }
        return dp[n-1]; //O(n^2)
    }
}
