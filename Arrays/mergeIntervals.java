class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(i -> i[0]));
        List<int[]> ans  = new ArrayList<>();

        int n = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=0;i<n;i++){
            if(intervals[i][0]<=end){ 
                //overlapping intervals 
                //update the end 
                end = Math.max(end,intervals[i][1]);

            }else{
                //add new interval
                ans.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}
