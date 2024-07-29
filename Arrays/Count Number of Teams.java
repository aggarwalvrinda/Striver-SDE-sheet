// recursion 
class Solution {
    int dp 
    public int solve1(int[] rating, int i, int count, int prev){
        if(count==3){
            return 1;
        }if(i>=rating.length){
            return 0;
        }

        //not take
        int notTake = solve1(rating, i+1, count, prev);

        //take
       int take = 0;
        if (prev == -1 || rating[prev] < rating[i]) {
            take = solve1(rating, i + 1, count + 1, i);
        }
        return take+notTake;
    }
    public int solve2(int[] rating, int i, int count, int prev){
        if(count==3){
            return 1;
        }if(i>=rating.length){
            return 0;
        }
        int notTake = solve2(rating, i+1, count, prev);
        
         int take = 0;
        if (prev == -1 || rating[prev] > rating[i]) {
            take = solve2(rating, i + 1, count + 1, i);
        }
        
        
        return take+notTake;
    }
    public int numTeams(int[] rating) {
       
       int ans1 = solve1(rating, 0, 0, -1);
       int ans2 = solve2(rating, 0, 0, -1);
       return ans1+ans2;
    }
}


//Approch 2
class Solution {
    public int numTeams(int[] rating) {
        int teams =0;
        int n = rating.length;
        for(int j=1;j<n-1;j++){
            //strictly increasing
            int smallerL=0;
            int largerR =0;
            int smallerR =0;
            int largerL = 0;
            for(int i=0;i<j;i++){
                if(rating[i]<rating[j]){
                    smallerL++;
                }else if(rating[i]>rating[j]){
                    largerL++;
                }
            }
            for(int k=j+1;k<n;k++){
                if(rating[k]>rating[j]){
                    largerR++;
                }else if(rating[k]<rating[j]){
                    smallerR++;
                }
            }
            teams += largerR*smallerL;
            teams+= largerL*smallerR;
            


        }
        return teams;
    }
}
