// recursion
class Solution {
    public int helper(int n){
        if(n==0){
            return 0;

        }
        int minCount=100000;
        int result =0;
        for(int i=1;i*i<=n;i++){
            result = 1+ helper(n-i*i);
            minCount = Math.min(result,minCount);
        }
        return minCount;
    }
    public int numSquares(int n) {
        return helper(n);
    }
}
//memoization
class Solution {
    int dp[] = new int[10001];
    public int helper(int n){
        if(n==0){
            return 0;

        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int minCount=100000;
        int result =0;
        for(int i=1;i*i<=n;i++){
            result = 1+ helper(n-i*i);
            minCount = Math.min(result,minCount);
        }
        return dp[n]=minCount;
    }
    public int numSquares(int n) {
        Arrays.fill(dp,-1);
        return helper(n);
    }
}
//bottom up
class Solution {
    
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int j=2;j<=n;j++){
            int minCount=100000;
            //int result =0;
            for(int i=1;i*i<=j;i++){
                
                minCount = Math.min(dp[j-i*i]+1,minCount);
            }
            dp[j]=minCount;

        }
        return dp[n];
    }
}
