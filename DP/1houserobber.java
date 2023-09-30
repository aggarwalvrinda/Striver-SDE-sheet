//Maximum sum of non adjecent numbers
//recursive solution time limit exceeded look for better approch 
class Solution {
    int solve(int nums[],int n){
        //base case
        if(n<0){
            return 0;
        }if(n==0) return nums[0];
        int incl = solve(nums,n-2)+nums[n];
        int exc = solve(nums,n-1)+0;
        return Math.max(incl,exc);


    }
    public int rob(int[] nums) {
        int n = nums.length;
        int ans=solve(nums,n-1);
        return ans;

    }
}

//with Memoization
class Solution {
    int dp[];
    int solve(int nums[],int n){
        //base case
        if(n<0){
            return 0;
        }if(n==0) return nums[0];
        //step3
        if(dp[n]!=-1) return dp[n];
        
        int incl = solve(nums,n-2)+nums[n];
        int exc = solve(nums,n-1)+0;
        

        //step2
        dp[n]=Math.max(incl,exc);
        return dp[n];

    }
    public int rob(int[] nums) {
        int n = nums.length;
         //step1
        dp= new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1; //intializes to -1
        }
        int ans=solve(nums,n-1);
        return ans;

    }
}

// tabular - bottom up approch 
class Solution {
    //int dp[];

    public int rob(int[] nums) {
        int n = nums.length;
        int dp[]=new int[n];
        // for(int i=0;i<n;i++){
        //     dp[0]=0;
        // }
        dp[0]=nums[0]; //base case\

        for(int i=1;i<n;i++){
             int incl=nums[i];
            if(i>1)incl+=dp[i-2];
            int exc = dp[i-1]+0;
            dp[i]=Math.max(incl,exc);
        }
        return dp[n-1];
        
    }
}
