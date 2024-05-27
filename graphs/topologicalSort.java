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
