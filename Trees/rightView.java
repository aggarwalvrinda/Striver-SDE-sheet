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
