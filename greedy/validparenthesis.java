/* Valid Parenthesis
Stack method make 2 stacks paranthesis stack , star stack 

Time complexity - O(n)
space - O(n)
*/

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> pstack = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                pstack.push(i);
            }else if(s.charAt(i)==')'){
                if(!pstack.isEmpty()){
                    pstack.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }

            }else if(s.charAt(i)=='*'){
                star.push(i);

            }
        }
        while(!pstack.isEmpty()){
            if(star.isEmpty()) return false;
            if(star.peek()<pstack.peek()) return false;
            pstack.pop();
            star.pop();
        }
        return true;
    }
}

/*can be done by greedy also

*/
