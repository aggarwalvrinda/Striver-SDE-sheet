// recursion 
// since repetition of cases we will use memoization 
class Solution {
    public int solve(String text1, String text2, int i, int j){
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+ solve(text1, text2, i+1,j+1);
        }else{
            return Math.max(solve(text1, text2,i,j+1), solve(text1, text2, i+1,j));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int i=0;
        int j=0;
        return solve(text1, text2, i,j);
    }
}

// memoization 2 variables are changing we will use 2d matrix 
class Solution {
    public int solve(String text1, String text2, int i, int j, int dp[][]){
        int ans=0;
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }
        //step 3
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+ solve(text1, text2, i+1,j+1,dp);
        }else{
            ans= Math.max(solve(text1, text2,i,j+1,dp), solve(text1, text2, i+1,j,dp));
        }
        //step 2
        return dp[i][j]= ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        //step1
        for(var i: dp){
            Arrays.fill(i,-1);
        }
        int i=0;
        int j=0;
        return solve(text1, text2, i,j,dp);
    }
}

//bottom up 
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
