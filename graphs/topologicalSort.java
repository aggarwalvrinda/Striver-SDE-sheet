/* Topological sort happenes in directed acyclic graph 
for topological sort we need to itereate for that we can traverse through dfs or bfs 
*/
// topological sort through DFS
// pehele mere bacho ko stack main dalo 
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[]visited, int u ,Stack<Integer> stack){
        //u -->v
        visited[u]= true;
        for(int v : adj.get(u)){
            if(visited[v] ==false ){
                dfs(adj,visited, v,stack);
                
            }
            
        }
        stack.push(u);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[V]; // in java it is already initialised to false or 0
        for(int i=0;i< V;i++){
            if(!visited[i]){
                dfs(adj,visited, i, stack);
            }
        }
        
        int[] result = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return result;
    }
}

//BFS 
//Kahns algorithm it depends on the indegree maintain the indegree

class Solution
{
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int N = V;
        int[] indegree = new int[V];
        Queue <Integer> q = new LinkedList<>();
        
        // fill indegree with values
        for(int u=0;u<N;u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }
        
        //push in queue with indegree =0
        for(int i=0;i<V;i++){
            if(indegree[i]==0)
            q.add(i);
        }
        // bfs
        
        int[] res = new int[V];
        int index = 0;
        while(!q.isEmpty()){
             int u = q.poll();  // Use poll to get and remove the front element
            
            res[index++] = u;
            for(int v: adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
                
            }
        }
        return res;
        
        
        
    }
}
