class Solution {
    //false = prime
    public int countPrimes(int n) {
        if(n<=1) return 0;
        boolean ans[] =new boolean[n];
        //int Limit = (int) Math.sqrt(n);
        for(int i=2; i < Math.sqrt(n); i++){
            if(ans[i]==false){
                for(int j=i*i; j<n; j+=i){
                    ans[j]=true;
                }
            }
        }
        

        int count =0;
        for(int i=2; i<n; i++){
            if(ans[i]==false){
                count++;
            }
        }
        return count;
    }
}
