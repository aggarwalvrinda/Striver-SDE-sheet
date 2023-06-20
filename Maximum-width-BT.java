//width = rightmost-leftmost+1

//find the index of ech and every node and then find the difference between the right and left 
 /* 
 indext ccan be found by the help of index index of left child is =2p+1
 index of right child is = 2p+2
 
 */


class Solution {
    public class vPair{
        TreeNode node =null;
        int idx = 0;
        vPair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        int leftmost=0;
        int rightmost=0;
        LinkedList <vPair> q = new LinkedList<>();
        q.add(new vPair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
             leftmost =q.getFirst().idx;
             rightmost=q.getFirst().idx;
            while(size-->0){
                vPair removePair=q.removeFirst();
                rightmost=removePair. idx;
                if(removePair.node.left!=null){
                    q.addLast(new vPair(removePair.node.left,removePair.idx*2+1));
                }if(removePair.node.right!=null){
                    q.addLast(new vPair(removePair.node.right,removePair.idx*2+2));
                }
                max=Math.max(max,rightmost-leftmost+1);

            }
        }
        return max;

    }
}
