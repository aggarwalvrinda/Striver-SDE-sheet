/*Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  */
//brute force

/* in this the 
time complexity is O(N)+O(N/2) 
space complexity is O(N)
*/
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int neg[] = new int[len/2];
        int pos[] = new int [len/2];
        int ans[] = new int[len];
        int negIdx = 0;
        int posIdx = 0;
        for(int i=0;i<len;i++){
            if(nums[i]<0){
                neg[negIdx++] = nums[i];
            }else{
                pos[posIdx++]= nums[i];
            }
            

        }
        for(int i=0;i<len/2 ; i++){
            ans[i*2] = pos[i];
            ans[2*i+1] = neg[i];
        }
        return ans;
        
    }
}
//better 
//time complexity - O(N)
//space complexity - O(N)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int ans[] = new int[len];
        int pos= 0; int neg =1;
        for(int i =0;i<len;i++){
            if(nums[i]>0){
                ans[pos] = nums[i];
                pos+=2;
            }else{
                ans[neg] = nums[i];
                neg+=2;
            }
        }
        return ans;
    }
}
