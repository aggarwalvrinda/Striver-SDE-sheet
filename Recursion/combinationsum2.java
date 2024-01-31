/*

This is the code I thought of initially here is a problem the initial time complexity was 2^n*k now since we are adding ans to a set now which will take log n time 
so for that reason we will have another solution

class Solution {
    Set<List<Integer>>ans;
    public Solution(){
        ans = new HashSet<>();
    }
    public void helper(int[] candidates, int indx, int target, List<Integer>picked){
        //base case
        if(indx==candidates.length){
            if(target==0){
                ans.add(new ArrayList(picked));
            }
            return;
        }
        //if picked
        if(candidates[indx]<=target){
            picked.add(candidates[indx]);
            int x = target-candidates[indx];

            helper(candidates,indx+1,x,picked);
            picked.remove(picked.size()-1);

        }
        //not picked
        helper(candidates,indx+1,target,picked);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> picked = new ArrayList<>();
        helper(candidates,0,target,picked);
        //hash set can be conerted to list;
         List<List<Integer>> arr = new ArrayList<>(ans);
        return arr;
    }
}
*/
// this is the code with better time complexity
class Solution {

    List<List<Integer>> ans;
    public Solution(){
        ans = new ArrayList<>();
    }
    public void helper(int[] candidates,int indx,int target, List<Integer> picked){
        int n=candidates.length;
        //base case
        if(indx==n){
            if(target==0){
                ans.add(new ArrayList(picked));
                
            }
            return;
        }
        //picked
        if(candidates[indx]<=target){
            picked.add(candidates[indx]);
            int x = target-candidates[indx];
            helper(candidates,indx,x,picked); 
            picked.remove(picked.size()-1);
        }
        //not picked
        helper(candidates,indx+1,target,picked);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> picked = new ArrayList<>();
        helper(candidates, 0,target,picked);
        return ans;
    }
}
