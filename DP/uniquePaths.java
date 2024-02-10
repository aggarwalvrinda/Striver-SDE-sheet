// recursion
class Solution {
    public int f(int i, int j){
        if(i ==0|| j==0){
            return 1;
        }
        if(i<0|| j<0){
            return 0;
        }
        int up =f(i-1,j);
        int left = f(i,j-1);
        return up+left;
    }
    public int uniquePaths(int m, int n) {
        return f(m-1,n-1);
    }
}

//memoization
class Solution {
    public static int f(int m,int n,int[][] dp){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        dp[m][n] = f(m-1,n,dp) + f(m,n-1,dp);
        return dp[m][n];
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return f(m-1,n-1,dp);
    }
}
//time complexity = O(mn);
// Tabulation 
class Solution {

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(i==0 && j==0) dp[0][0] =1;
               else{
                   int up =0;
                   int left =0;
                   if(i-1>=0){
                        up = dp[i-1][j];
                   } 
                   if(j-1>=0){
                        left = dp[i][j-1];
                   }
                   dp[i][j] = up+left;
               }
            }
        }
        return dp[m-1][n-1];
    }
}
