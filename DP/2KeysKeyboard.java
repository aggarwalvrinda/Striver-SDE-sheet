// recursion 
class Solution {
    public int solve(int currA, int clip, int n ){
        if(currA==n){
            return 0;
        }
        if(currA>n){
            return 1000000;
        }
        int copypaste =2+ solve(currA*2, currA, n);
        int paste = 1+ solve(currA+clip, clip, n);
        return Math.min(paste, copypaste);
    }
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        return 1+solve(1,1,n);
    }
}

//Memoization 
class Solution {
    public int solve(int currA, int clip, int n , int dp[][]){
        if(currA==n){
            return 0;
        }
        if(currA>n){
            return 1000000;
        }
        if(dp[currA][clip]!=-1) return dp[currA][clip];
        int copypaste =2+ solve(currA*2, currA, n, dp);
        int paste = 1+ solve(currA+clip, clip, n, dp);
        return dp[currA][clip]=Math.min(paste, copypaste);
        
    }
    public int minSteps(int n) {
        int dp [][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        if(n==1){
            return 0;
        }
        return 1+solve(1,1,n, dp);
    }
}
