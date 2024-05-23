//dfs
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[]visited, boolean inRec[], int u){
        visited[u]=true;
        inRec[u]=true;
        for(int v: adj.get(u)){
            //id not visited 
            if(visited[v] == false && dfs(adj,visited,inRec,v)){
                return true;
            }else if(inRec[v]==true){
                return true;
            }
        }
        inRec[u]=false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] inRec = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i] && dfs(adj,visited,inRec,i)){
                return true;
            }
        }
        return false;
        
        
    }
}
