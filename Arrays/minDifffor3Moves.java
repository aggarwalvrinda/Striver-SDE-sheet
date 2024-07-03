// easy approch 
class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        int result =Integer.MAX_VALUE;
        Arrays.sort(nums);
        if(n<=3){
            return 0;
        }
        result = Math.min(result, nums[n-4]-nums[0]);
        result = Math.min(result, nums[n-3]- nums[1]);

        result = Math.min(result, nums[n-2]- nums[2]);

        result = Math.min(result, nums[n-1] - nums[3]);
        return result;
    }
}

//my solution it gave correct ans for the given test cases but fails in other 
class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0];
        int diff =0;
        int count=0;
        for(int i=n-1;i>0;i--){
            if(nums[i]>min){
                count++;
                if(n==3){
                    return 0;
                }else{
                    nums[i]= nums[n-4];
                }
    
            }if(nums[i]==min){
                continue;
            }
            if(count==3){
                diff= nums[n-1]-min;
            }
        }
        return diff;
    }
}
