// Approch 1 
// TC -- O(n^2)
//SC -- O(n)

class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        int i=0;
        while(arr.size()>1){
            int indx = (i+k-1)%arr.size();
            arr.remove(indx);
            i = indx;


        }
        return arr.get(0);
    }
}

// Approch 2 QUeue
// TC - 
// SC


//recursion
class Solution {
    public int solve(int n, int k){
        if(n==1){
            return 0;
        }
        
        int indx = solve(n-1,k);
        indx = (indx+k)%n;
        return indx;
        
    }
    public int findTheWinner(int n, int k) {
        int result = solve(n,k);
        return result+1;
    }
}
