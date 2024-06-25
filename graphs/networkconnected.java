class Solution {
    int parent[];
    int rank[];

    public int find(int i){
        if(parent[i]==i){
            return i; // khud hi khud ka parent hai
        }
        return parent[i]= find(parent[i]); // recursiive call 
    }
    public void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent == y_parent){
            // same set main hai 
            return;
        }
        if(rank[x_parent]> rank[y_parent]){
            parent[y_parent ]= x_parent;

        }else if(rank[y_parent]> rank[x_parent]){
            parent[x_parent] = y_parent;
        }else{
            // rank is same any one can be parent and increase the rank of the one that is parent 
            parent[x_parent]= parent[y_parent];
            rank[y_parent]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        // code here

        if(connections.length<n-1) return -1;

        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]= 1;
        }
        int components = n; // every system is linked to itself initially 
        for(int v[]: connections){
            if(find(v[0])!= find(v[1])){
                union(v[0], v[1]);
                components--;
            }
        }
        return components-1;


    }
}
