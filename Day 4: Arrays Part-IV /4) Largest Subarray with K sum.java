// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        Map<Long, Integer> map = new HashMap<>();
        int n = arr.length;
        int ans = 0;
        long sum = 0;
        
        map.put((long)0,-1);
        
        for(int i=0;i<n;i++){
            sum += arr[i];
            
            if(map.containsKey(sum - k)){
                ans = Math.max(ans , i-map.get(sum-k));
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return ans;
    }
}
