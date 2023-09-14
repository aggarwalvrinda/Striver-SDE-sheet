/*Brute force - 4 loop
Time complexity - O(n^4)
space complexity - 
simple as that all test cases might not pass as time exceeds 
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
          for(int j=i+1;j<n;j++){
            for(int k=j+1;k<n;k++){
              for(int l=k+1;l<n;l++){
                int sum = nums[i]+nums[j];
                sum+= nums[k];
                sum+= nums[l];
                if(sum==target){
                  List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k],nums[l]);
                        temp.sort(null);
                        st.add(temp);
                }
              }
            }
          }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}
/*Better approch

*/
