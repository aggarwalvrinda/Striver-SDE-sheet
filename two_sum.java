/*this is an easy question 
there are two things given 1. Array 2.Target Sum
we have to find 2 such numbers from and array which add up to the target sum

Brute Force Method
just put a pointer on one end of the array and start to calculate the sum from the next 

[1,2,3,4,0,-1,-2,6]
 i j 

the time complexty for this solution is O(n^2)
here is the brute force code 
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                   

                }
            }
        }return arr;
    }
}

/* here is another way in which we can find the 2sum 
HASHING METHOD using hash maps 
eg 2,7,11,15 target=9
we will check 2+?=9 ?=7
check 7 in the hash map  
if not then add 2 with index in the hash map
then check 7+?=9 ?=2
check 2 in heap if yes add that in new arr and return that arr in the end
|
|
|
|   
|_2,0____|






*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        HashMap<Integer,Integer> Map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //if(nums[i]>target) continue; // this line is not needed because for example if we have target sum as zero and the ans will be -3+3 = 0 in this case 3 is definately > than 0 but will be considered 

            int find = target-nums[i];
            if(Map.containsKey(find)){
                ans[1]=i;
                ans[0]=Map.get(find);
                return ans;

            }
            Map.put(nums[i],i);
        }
        return new int[]{};
    }
}
