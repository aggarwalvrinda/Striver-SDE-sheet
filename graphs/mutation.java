// using BFS 
/*
when ever there is a string which needa to be convereted to another string with minimum steps we will have to use BFS 

BFS - queue , visited

*/

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // visited 
        Set<String> visited = new HashSet<>();
        for(String v: bank){
            bankSet.add(v);
        }
        q.add(startGene);
        visited.add(startGene);
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            for (int j = 0; j < size; j++){
                String curr = q.peek();
                q.poll();
                if(curr.equals(endGene)){
                    return level;
                }
                for(char ch : "ACGT".toCharArray()){
                    for(int i=0;i< curr.length();i++){
                        char arr[] = curr.toCharArray();
                        arr[i]= ch;// first try with A then C, G T
                        String neigh = String.valueOf(arr);
                         
                        if(!visited.contains(neigh)  && bankSet.contains(neigh)){
                            // not present in visited and bankset main hain then 
                            visited.add(neigh);
                            q.add(neigh);

                        }
                    }
                }
                
            }
            level++;
        }
        return -1;


    }
}
