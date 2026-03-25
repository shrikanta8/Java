class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int maxSeq=1; 

        for(int num:nums){
            set.add(num);
        }

        for(int num:nums){
            if(!set.contains(num-1)){
                int ele=num+1;
                while(set.contains(ele)){
                    ele++;
                }
                maxSeq=Math.max(maxSeq,ele-num);
            }
        }
        return maxSeq;
    }
}
