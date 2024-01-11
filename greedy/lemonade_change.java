//solution 
// time complexity - O(n)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
     
        for(int i=0;i<bills.length;i++){
            if(bills[0]>5){
                return false;
            }else if(bills[i]>=5){
                if(bills[i]==5){
                    five++;
                }else if(bills[i]==10){
                    ten++;
                    if(five>0){
                        five--;
                    }else{
                        return false;
                    }
                }else if(bills[i]==20){
                    if(ten>0){
                        ten--;
                        five--;
                    }else{
                        five-=3;

                    }
                }
            }
            if(five<0){
                return false;
            }
        }
        return true;
    }
}
