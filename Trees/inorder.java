// recursion 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
        
    }
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}


// Morris Traversal 

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        ArrayList<Integer> result = new ArrayList<>();
        while(curr!= null){
            if(curr.left==null){
            // vist 
            result.add(curr.val);
            curr = curr.right;
        }else{
            // curr.left!= null;
            TreeNode leftChild = curr.left;
            while(leftChild.right!= null){
                leftChild = leftChild.right;
                

            }
            leftChild.right = curr;

            TreeNode temp = curr;
            curr = curr.left;
            temp.left = null; 
            // remove connection from left;
        }
        }
        return result;
    }
}
