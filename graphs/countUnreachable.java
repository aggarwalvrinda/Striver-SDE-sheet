// dfs 
class Solution {
    public void dfs(int u, HashMap<Integer, List<Integer>> adj, boolean[]visited, int []size){
        visited[u]= true;
        size[0]++;
        for(int v: adj.get(u)){
            if(!visited[v]){
                dfs(v, adj,visited, size);
            }
        }


    }
    public long countPairs(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        // Populate adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        long remaining = n;
        long result=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int[] size = new int[1]; // Array to keep track of component size
                dfs(i, adj, visited, size);
                result += (remaining - size[0]) * (long)size[0];
                remaining -= size[0];
            }

        }

        return result;

    }
}

// dsu // can be done again a little difficult

class Solution {
    int parent[];
    int rank[];
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void union (int x, int y){
        int parent_x = find(x); 
        int parent_y= find(y);

        if(rank[parent_x]> rank[parent_y]){
            parent[parent_y] = parent_x;

        }else if(rank[parent_x] == rank[parent_y]){
            return ;
        }else if(rank[parent_y]> rank[parent_x]){
            parent[parent_x] = parent_y;
        }else{
            parent[parent_y] = parent_x;
            rank[parent_x]++;
        }

    }
    public long countPairs(int n, int[][] edges) {
        parent= new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i; // parent of itself
        }
        for(int vec[]: edges){
            int u = vec[0];
            int v = vec[1];

            union (u,v);
        }
        long[] map = new long[n];
        for(int i=0;i<n;i++){
            int par = find(i);
            map[par]++;
        }
        long result=0;
        long remaining=n;
        
        for(long s: map){
            if(s==0){
                continue;
        }
            //long size= map[i];
            remaining-= s;
            result += s * (remaining-s);
            
        }
        return result;

      

        
    }
}
