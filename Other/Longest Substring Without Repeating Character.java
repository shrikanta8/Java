class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int ans=0,left=0;

        int[] arr=new int[128];
        Arrays.fill(arr,-1);

        for(int right=0;right<n;right++){
            if(arr[s.charAt(right)] >= left ){
                left=arr[s.charAt(right)] + 1;
            }
            arr[s.charAt(right)]=right;
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
