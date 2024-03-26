//reallt good question needs to solved in toc =O(n) and SC = O(1);
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean onePresent = false;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                onePresent =true;
            }
            if(nums[i] <=0 || nums[i]>n){
                nums[i]=1;
            }
            
        }
        if(onePresent == false){
            return 1;
        }
        for(int i=0;i<n;i++){
            int num = Math.abs(nums[i]);
            int indx = num-1;
            if(nums[indx]<0) continue;

            nums[indx] *= -1;

        }
        for(int j=0;j<n;j++){
            if(nums[j]<0) continue;
            if(nums[j]>0){
                return j+1;
            }
        }
        return n+1;
    }
}
