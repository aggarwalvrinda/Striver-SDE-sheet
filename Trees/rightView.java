// level order traversal 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int i=0;
            TreeNode curr =null;
            while(i<n){
                curr = q.peek();
                q.poll();
                i++;

                if(curr.left!= null){
                    q.add(curr.left);
                }if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(curr.val);
        }
        return result ;
    }
}

// Dfs 
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

 // using dfs / preorder
class Solution {
    public void preOrder(TreeNode root, int n , ArrayList<Integer> result){
        if(root==null){
            return ;
        }
        if(result.size()<n){
            result.add(root.val);
        }
        preOrder(root.right, n+1, result);
        preOrder(root.left, n+1, result);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, 1, result);
        return result;
    }
}
