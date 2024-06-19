// recuresion 
class Solution {
    
    public int solve(int[] jobDifficulty, int n , int x , int d){
        
        if(d==1){
            int maxD = 0;
            for(int i=x;i<n;i++){
                maxD = Math.max(maxD, jobDifficulty[i]);
            }
            return maxD;
        }

        int finalR = Integer. MAX_VALUE;
        int maxD  =0;


        for(int i=0;i<=n-d; i++){
            maxD = Math.max(maxD,jobDifficulty[i]);
            int result = maxD+ solve(jobDifficulty, n, i+1, d-1);
            finalR = Math.min(finalR, result); 
        }
        return finalR;

    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        
        int n = jobDifficulty.length;
        if(n<d){
            return -1;
        }
        return solve(jobDifficulty, n , 0, d);
       
    }
}

// memoization since there are two parameters changing then we will use a matrix 
