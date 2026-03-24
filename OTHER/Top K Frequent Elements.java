import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        List<Integer>[] bucket= new List[n+1];
        Map<Integer,Integer> freq= new HashMap<Integer,Integer>();

        for(int num:nums){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

        for(int key : freq.keySet()){
            int freqNum=freq.get(key);

            if(bucket[freqNum]==null){
                bucket[freqNum]=new ArrayList<Integer>();
            }

            bucket[freqNum].add(key);
        }

        int[] ans = new int[k];
        int count=0;

        for(int i=n;i>=0 && count<k;i--){
            if(bucket[i]!=null){
                for(int ele:bucket[i]){
                    ans[count++]=ele;
                }
            }
        }
        return ans;

    }
}
