class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        List<int[]> meetings = new ArrayList<>();
        int n = start.length, ans = 0, lastEnd = -1;
        
        for(int i=0;i<n;i++){
            meetings.add(new int[]{end[i],start[i]});
        }
        
        meetings.sort((a,b) -> Integer.compare(a[0],b[0]));
        
        for(int[] meet:meetings){
            if(meet[1] > lastEnd){
                lastEnd = meet[0];
                ans++;
            }
        }
        return ans;
    }
}
