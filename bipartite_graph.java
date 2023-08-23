/* The graph is said to be bipartite if all the nodes can be divided into 2 mutually exclusive and exhaustive sets such 
that all edges are across sets there are a few ways to figure out if a graph is bipartite or not 
eg

0 ----- 1
|       |
|       |
|       |
3-------2   this graph is bipartite if the graph is acyclic and if cyclic have even edges then it is 
*/

// method 1: BFS
/*in this methodwe will color th first node with blue and the adject one with red if the 2 adjecent nodes are of 
same color then they are not bipartite 
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int color[] = new int[len];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<len;i++){
             if (color[i] != 0) { // going to everynode as the graph can be a cyclic
                continue; // Node is already colored
            }
            q.add(i);
            color[i]=1;
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int next : graph[curr]){
                     if(color[next]==0){
                    color[next]= -color[curr];
                    q.add(next);
                    }
                    if(color[next] == color[curr]) return false;
                }
               
                
            }
        }
        return true;

    }
}
/* this is the code for DFS 
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colour[] = new int[n];
        for(int i=0;i<n;i++){
            if(colour[i]==0 && !isValid(graph,colour,1,i)){
                return false;
            }
        }
        return true;
    }
    public boolean isValid(int[][] g, int[]colour,int c,int node){
        if(colour[node]!=0) return colour[node]==c;
        colour[node]=c;
        for(int next:g[node]){
            if(!isValid(g,colour,-c,next)) return false;

        }
        return true;
    }
}
