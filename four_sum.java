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
/*Better approach

but with error this is not able to pass all the test cases because it most probably passes the int value for this test case nums =
[1000000000,1000000000,1000000000,1000000000]
target =
-294967296 it fails because number too big 
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            
            for(int j=i+1;j<n;j++){
                Set<Integer> hashset = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    int l = target -(nums[i]+nums[j]+nums[k]);
                    if(hashset.contains(l)){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],l);
                        temp.sort(null);
                        st.add(temp);
                    }else{
                        hashset.add(nums[k]);
                        //k++;
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}

the following is a better approch using keyword long
Time complexity- o(n^3)*log(number of elements in a set)
Space complexity- o(n)+o(quads)*2 ----- o(quads)*2 is the required for storing in set and also for returning the ans 
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            
            for(int j=i+1;j<n;j++){
                Set<Long> hashset = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long l = target - sum;
                    if(hashset.contains(l)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int)l);
                        temp.sort(Integer::compareTo);
                        st.add(temp);
                    }
                    hashset.add((long) nums[k]);
                    // else{
                    //     hashset.add((long) nums[k]);
                    //     //hashset.add(nums[k]);
                    //     //k++;
                    // }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}
//two pointer approch

// time complexity - o(n^3)
//space - we are not using space to solve the question but to store the result 
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans= new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                     long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum<target){
                        k++;
                    }else if(sum>target){
                        l--;
                    }else{
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                       ans.add(temp);
                        k++;l--;
                        while(k<l && nums[k]==nums[k-1])k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                }

            }
        }
        return ans;
    }
}
