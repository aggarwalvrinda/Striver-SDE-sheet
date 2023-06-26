// Can be done with the help of both sorting and heaps this answer is through heaps the complexity is nlogk
/*Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();//minHeap as it is largest element we need to find 
        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
            
        }
        for(int i=k;i<nums.length;i++){
            if(minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();


    }
}
