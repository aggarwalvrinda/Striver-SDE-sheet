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
