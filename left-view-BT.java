class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> result = new ArrayList<>();
      if(root==null){
          return result;
      }
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      //q.add(null);
      while(!q.isEmpty()){
          //Node curr = q.poll();
          int size = q.size();
          int i=0;
          while(i<size){
              Node curr = q.poll();
              i++;
              if(i==1){
                  result.add(curr.data);
              }if(curr.left!=null){
                  q.add(curr.left);
              }if(curr.right!=null){
                  q.add(curr.right);
              }
              
          }
          
      }
      return result;
    }
}
