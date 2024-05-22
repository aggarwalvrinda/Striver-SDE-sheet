//DFS

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, int parent){
        visited[u]= true;
        for(int v : adj.get(u)){ // Iterate over all adjacent vertices of u
            if(v==parent) continue;
            if(visited[v]){
                return true;
            }
            if(dfs(adj,v,visited,u)){
                return true;
            }
        }
        return false;
        
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        // this auto initialize to false as boolean initial value is false
        for(int i=0;i<V;i++){ //for loop because if no loop it will not check for the other values in graph
           if(!visited[i] && dfs(adj, i, visited,-1) ){
               //not visited and cycle 
               return true;
           }
            
        }
        return false;
        
    }
}

//BFS
class Solution {
    // Function to detect cycle in an undirected graph.
    class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
        
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(u, -1));
        visited[u]=true;
        while(!q.isEmpty()){
            Pair node = q.poll();
            int current = node.first;
            int parent = node.second;
            for(int v : adj.get(u)){
                if(visited[v]==false){
                    q.add(new Pair(v,current));
                    visited[v]=true;
                }else if(v!=parent){
                    return true;
                }
            }

        }
        return false;
        
        
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        // this auto initialize to false as boolean initial value is false
        for(int i=0;i<V;i++){ //for loop because if no loop it will not check for the other values in graph
           if(!visited[i] && bfs(adj, i, visited) ){
               //not visited and cycle 
               return true;
           }
            
        }
        return false;
        
    }
}
