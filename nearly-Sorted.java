class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<=k;i++){
            minHeap.add(arr[i]);
            
        }
        for(int i=k+1;i<arr.length;i++){
            result.add(minHeap.poll());
            minHeap.add(arr[i]);
            
        }
         while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
        
    }
}
