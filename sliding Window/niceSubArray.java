class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int odd =0;
        int prev =0;
        int i=0;
        int j= 0;
        int ans =0;
        
        while(j<n){
            if(nums[j]%2!= 0){
                odd++;
                prev =0;
            }while( odd==k){
                prev++;
                if(i<n && nums[i]%2==1){
                    odd--;
                }
                i++;
               

            }
            ans+= prev;
            j++;
        }
        return ans;
    }
}
