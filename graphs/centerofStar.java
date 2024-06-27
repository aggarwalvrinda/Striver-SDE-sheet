//HashMap
class Solution {
    public int findCenter(int[][] edges) {
        int n = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<edges.length;i++){
            map.put(edges[i][0], map.getOrDefault(edges[i][0],0)+1);
            map.put(edges[i][1], map.getOrDefault(edges[i][1],0)+1);
            n = Math.max(n, edges[i][0]);
            n = Math.max(n, edges[i][1]);

        }
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue()==n-1){
                return e.getKey();
            }
        }
        return -1;
    }
}

// 
class Solution {
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        if(a== edges[1][0] || a== edges[1][1]){
            return a;
        }else{
            return b;
        }
    }
}
