/*This is the solution I thought of initially */
/*
class Solution {
    public int countGoodNumbers(long n) {
        int count =0;
        for(int i=0;i<Integer.MAX_VALUE;i++){
            if(i.length==n){
                int j=0;
                while(j<n){
                    if(j%2==0 && i[j]%2==0){
                        j++;
                        if(j%2!=0 && i[j]%j!=0){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
I thoght that I will have to itrate it twice such that I have to first go through the all the numbers of n digits and then check for each digit if it is at the right place 

this will definetly take a lot of time and increase the time complexity 
*/

class Solution {
    private long MOD=1_000_000_007;
    public long power(long x, long n){
        if(n==0){
            return 1;
        }
        long temp = power(x,n/2);
        
        // If n is even, return (x^(n/2))^2
        if(n%2==0){
            return (temp * temp)% MOD;
        }
        // If n is odd, return (x^(n/2))^2 * x
        else{
            return (x * temp * temp)% MOD;
        }
    }
    public int countGoodNumbers(long n) {
        long odd_place = n/2;
        long even_place = n/2+ n%2;
        long a = power(5,even_place);
        long b = power(4,odd_place);
        long ans=(a*b)%MOD;
        return (int)(ans);
    }
}
// tine complexity -O(N)
