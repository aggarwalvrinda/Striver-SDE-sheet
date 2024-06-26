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
    
    public void inorder(TreeNode root, List<Integer> res ){
        if(root==null){
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    public TreeNode solve(int l, int r, List<Integer> res ){
        if(l>r){
            return null;
        }
        int mid = l+(r-l)/2;
        TreeNode node = new TreeNode(res.get(mid));
        node.left = solve(l,mid-1,res);
        node.right = solve(mid+1,r, res);
        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int n = res.size();
        
        return solve(0,res.size()-1,res );
    }
}
