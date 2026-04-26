class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, (i,j) -> Integer.compare(i[0], j[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        // int[] it keeps reference
        result.add(newInterval);

        for(int[] interval:intervals){
            if(interval[0] > newInterval[1]){
                newInterval = interval;
                result.add(newInterval);
            }
            else{
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
