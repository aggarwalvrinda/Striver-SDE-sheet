
class Solution {
    // Function to return Breadth First Traversal of given graph.

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer>bfs=new ArrayList<>();
        Queue <Integer> q = new LinkedList<>();
        boolean vist[]=new boolean[V];
        q.add(0);vist[0]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            bfs.add(curr);
             for(Integer i:adj.get(curr)){
                 if(vist[i]==false){
                     vist[i]=true;
                     q.add(i);
                 }
            }
           
        }
        return bfs;
  }
}
