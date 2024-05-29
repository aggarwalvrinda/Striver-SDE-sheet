// Brute force technique was able to do on my own 
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        //brute force tech 
        int res =0;
        for(int i=0;i<s.length();i++){
             int difference = Math.abs((int) s.charAt(i) - (int) t.charAt(i));
             if(s.charAt(i) == t.charAt(i)){
                res++;
             }else if(maxCost >= difference){
                maxCost-= difference;
                res++;

             }else{
                return res;
             }
        }
        return res;
    }
}

//Sliding Window technique 

