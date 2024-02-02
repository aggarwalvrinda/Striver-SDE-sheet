class Solution {
    List<List<Integer>> ans;
    public Solution(){
        ans = new ArrayList<>();
    }
    public void helper(int i,int n, int k, List<Integer>picked){
        if(k==0){
            if(n==0){
                ans.add(new ArrayList(picked));
            }
            return;
            
        }
        if(i>9) return;
        picked.add(i);
        helper(i+1,n-i,k-1,picked);
        picked.remove(picked.size()-1);
            
        
        //not picked
        helper(i+1,n,k,picked);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>picked = new ArrayList<>();
        helper(1,n,k,picked);
        return ans;
    }
}

//solved it on my own 
