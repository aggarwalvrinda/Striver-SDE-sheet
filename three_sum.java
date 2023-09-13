/*BRUTE FORCE
three loops are applied 
in this case the complexity is O(n^3);
also we have used sets so that non of them is repeated 
*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
         Set<List<Integer>> st = new HashSet<>();

        // check all possible triplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}
/*For better approch
in this we know that i+j+k=0 to reduce the complexity say for n^2
k=-(i+j) if we assign this we will get reduced complexity 
*/

/*initially we thought of this solution 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len =nums.length;
        int ans[]=new int [3];
        HashMap<Integer,Integer>map =new HashMap<>();
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int k= -(nums[i]+nums[j]);
                if(map.containsKey(k)){
                    ans[0]=nums[i];
                    ans[1]=nums[j];
                    ans[2]=nums[k];
                    Arrays.sort(ans);
                    st.add(ans);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(st);
        return result;
    }
} but in this case we will not get the correct ans 
because for example there is a probem of repeating elements in which we get this problem -(2-4) which is 2 and 2 is already in the array which we cant
use beause it is already being used as i

so for now think of it like [-1,0,1,2,-1,-4] -1,1 is i and j respectively add 0,1,2 in the heap 
*/

//optimised code for O(n^2)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /
        Set<List<Integer>> st= new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int k= -(nums[i]+nums[j]);
                if(hashset.contains(k)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], k);
                        temp.sort(null);
                        st.add(temp);
                    
                    //j++;
                }hashset.add(nums[j]);
            }
            
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}

/* For better Approch - 2 pointer approch 
this is the best approach in which i is fixed in the front j is i+1 and k is at the end of the array this already sorted 

there will be 2 moving pointers i.e. j(starts from i+1) and k(starts from the last index). The pointer j will move forward and the pointer k will move backward until they cross each other while the value of i will be fixed.

Now we will check the sum i.e. arr[i]+arr[j]+arr[k].
If the sum is greater, then we need lesser elements and so we will decrease the value of k(i.e. k–).
If the sum is lesser than the target, we need a bigger value and so we will increase the value of j (i.e. j++).
If the sum is equal to the target, we will simply insert the triplet i.e. arr[i], arr[j], arr[k] into our answer and move the pointers j and k skipping the duplicate elements(i.e. by checking the adjacent elements while moving the pointers).

time complexity = nlogn +(m*n);
Space complexity: O(1) - we are not using any extra space
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      int n=nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<n;i++){
          if(i>0 && nums[i]==nums[i-1]) continue;
          int j=i+1;
          int k=n-1;
          while(k>j){
            int sum = nums[i]+nums[j]+nums[k];
            if(sum>0){
              k--;
            }else if(sum<0){
              j++;
            }else{
              List<Integer> temp = Arrays.asList(nums[i], nums[j],nums[k]);
              ans.add(temp);
              j++;
              k--;
              while(j<k && nums[j]==nums[j-1])j++;
              while(j<k && nums[k]==nums[k+1]) k--;
            }
          }

        }
        return ans;
    }
}
