// Approch 1 
// takes extra space that is check just to check at which index i last flipped 
class Solution {
   
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        boolean check []= new boolean[n];
        int ans =0;
        int flipCount=0;

        for(int i=0;i<n;i++){
            if(i>=k && check[i-k]==true){
                flipCount--;
            }
            if(flipCount %2 == nums[i]){
                if(i+k>n){
                    return -1;
                }
                flipCount++;
                check[i]= true;
                ans++;


            }
        }

        return ans;
    }
}

//Approch 2 
  class Solution {
   
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        //boolean check []= new boolean[n];
        int ans =0;
        int flipCount=0;

        for(int i=0;i<n;i++){
            if(i>=k && nums[i-k]==5){
                flipCount--;
            }
            if(flipCount %2 == nums[i]){
                if(i+k>n){
                    return -1;
                }
                flipCount++;
                nums[i]= 5;
                ans++;


            }
        }

        return ans;
    }
}

//Approch 3 
class Solution {
   
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        //boolean check []= new boolean[n];
        int ans =0;
        int flipCount=0;
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(i>=k){
                flipCount -=deque.peekFirst();
                deque.pollFirst();

            }
           
            if(flipCount %2 == nums[i]){
                if(i+k>n){
                    return -1;
                }
                flipCount++;
                
                ans++;
                deque.addLast(1);
                


            }else{
                deque.addLast(0); //no flip

            }
        }

        return ans;
    }
}
