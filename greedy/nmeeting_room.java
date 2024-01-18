class meeting{
    int start;
    int end;
    int pos;
    meeting(int start,int end, int pos){
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}
class meetingComparator implements Comparator<meeting>{
    public int compare(meeting m1, meeting m2){
        if(m1.end<m2.end) return -1;
        else if(m1.end>m2.end) return 1;
        else if(m1.pos<m2.pos) return -1;
        return 1;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int count =1;
        ArrayList<meeting> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new meeting(start[i],end[i],i+1));
        }
        Collections.sort(arr,new meetingComparator());
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr.get(0).pos);
       
        int limit = arr.get(0).end;
        for(int i=1;i<n;i++){
            if(arr.get(i).start>limit){
                limit=arr.get(i).end;
                answer.add(arr.get(i).pos);
                count++;
            }
        }
        return answer.size();
        
        
    }
}
