class Solution {
    public boolean hasDuplicate(String s1, String s2){
        int nums[] = new int[26];
        //chech also "aa";
        for(int i =0;i< s1.length();i++){
            int val = s1.charAt(i)-'a';
            if(nums[val]>0){
                return true;
            }
            nums[val]++;
        }
        for(int i =0;i< s2.length();i++){

            if(nums[s2.charAt(i)-'a']>0){
                return true;
            }
        }
        return false;
    }
    public int solve(int i,List<String> arr, String temp, int n ){
        if(i>= n){
            return temp.length();
        }
        int include =0;
        int exclude =0;
        if(hasDuplicate(arr.get(i),temp)){
            //exclude
            exclude = solve(i+1, arr, temp, n);

        }else{
            exclude = solve (i+1, arr, temp, n);
            include = solve (i+1, arr, temp+ arr.get(i), n);
        }
        return Math.max(include, exclude);

    }
    public int maxLength(List<String> arr) {
        String temp="";
        int n = arr.size();
        int i =0;
       return solve(i, arr, temp, n);
    }
}



//after memoization 
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public boolean hasDuplicate(String s1, String s2){
        int nums[] = new int[26];
        //chech also "aa";
        for(int i =0;i< s1.length();i++){
            int val = s1.charAt(i)-'a';
            if(nums[val]>0){
                return true;
            }
            nums[val]++;
        }
        for(int i =0;i< s2.length();i++){

            if(nums[s2.charAt(i)-'a']>0){
                return true;
            }
        }
        return false;
    }
    public int solve(int i,List<String> arr, String temp, int n ){
        if(i>= n){
            return temp.length();
        }
        if(map.containsKey(temp)){
            return map.get(temp);
        }
        int include =0;
        int exclude =0;
        if(hasDuplicate(arr.get(i),temp)){
            //exclude
            exclude = solve(i+1, arr, temp, n);

        }else{
            exclude = solve (i+1, arr, temp, n);
            include = solve (i+1, arr, temp+ arr.get(i), n);
        }
       int result = Math.max(include, exclude);
        map.put(temp, result);
        return result;

    }
    public int maxLength(List<String> arr) {
        String temp="";
        int n = arr.size();
        int i =0;
       return solve(i, arr, temp, n);
    }
}
