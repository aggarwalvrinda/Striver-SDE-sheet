/*First DP problem*/

/*First approch is recursion - found out because we have to make a choice either 1 step or 2 step
f(0)=f(1)+f(2)
Even though the time limit is exceeded because of overlapping and can have a better approch using DP

also a way to write this code 
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
*/
class Solution {
    int solve(int n,int i){//i is the current step 
        if(i==n){ //base case if the current stair is same as target
           return 1;
        }
        if(i>n){
            return 0;
        }
        return solve(n,i+1)+solve(n,i+2);

    }
    public int climbStairs(int n) {
        int ans = solve(n,0);
        return ans;
    }
}

//Even though this is memoised idk why it is not giving me correct ans
/*
class Solution {
    public int climbStairs(int n) {
        //step 1
        int dp[]=new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=-1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if(dp[n]!= -1){
            return dp[n];
        }
        //step 2
        dp[n]= climbStairs(n-1) + climbStairs(n-2);
        return dp[n];
    }
}

*/
// this is the best solution you can actually get 
/* in this solution
Time complexity: O(N);
in this we are making an array to store - this is a 1d array as we only have 1 variable n 
initially the value of indx 0 1 is set to 1 and indx 2 will be 1+1 which is 2 it can climb upto 2 index in 2 ways
*/
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
