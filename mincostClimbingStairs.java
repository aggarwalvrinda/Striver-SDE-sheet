/*Recursion se - tle*/

class Solution {
    int solve(int[] cost,int n){
        if(n==0){
            return cost[0];
        }
        if(n==1){
            return cost[1];
        }
        //int ans = cost[n]+ Math.min(solve(cost,n-1),solve(cost,))
        return Math.min(solve(cost,n-1),solve(cost,n-2))+cost[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans = Math.min(solve(cost,n-1),solve(cost,n-2));
        return ans;
    }
}

/*MEMOIZATION - DP*/
class Solution {
    int[] dp;
    int solve(int[] cost,int n){
        if(n==0){
            return cost[0];
        }
        if(n==1){
            return cost[1];
        }
        //STEP 3
        if(dp[n]!= -1){
            return dp[n];
        }
        //STEP 2
        dp[n]= Math.min(solve(cost,n-1),solve(cost,n-2))+cost[n];
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //STEP1
        dp= new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        int ans = Math.min(solve(cost,n-1),solve(cost,n-2));
        return ans;
    }
}

// Tabular - bottom up 
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int dp[] = new int[n];

        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2;i<n;i++){
            
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);

        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
