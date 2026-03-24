class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();

        boolean[] dp=new boolean[n+1];
        Set<String> set=new HashSet<>();
        set.addAll(wordDict);

        dp[n]=true;

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                dp[i]=dp[j+1] && set.contains(s.substring(i,j+1));
                if(dp[i])
                    break;
            }
        }
        return dp[0];
    }
}
