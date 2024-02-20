/* this is quite an easy question if you only go by naive approch here are 4 approches

1. Naive - sorting 
2. Formula based 
3. Bit manupilation
4. hash Map

*/

//Approch 1 through sorting 
//TC - O(NlogN) - sorting
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}
//Approch 2
/*This approach uses the formula to calculate the sum of the first n numbers (n*(n+1)/2), then subtracts 
the sum of the array from it. The result is the missing number.
TC - O(N)
*/
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1) /2;
        int arrSum=0;
        for(int i=0;i<nums.length;i++){
            arrSum+= nums[i];

        }
        int ans = sum- arrSum;
        return ans;
    }
}
