class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>(); 

        int n=nums.length;

        for(int i=0;i<n;i++){
            int secondNum=target-nums[i];

            if(numMap.containsKey(secondNum)){
                return new int[]{i,numMap.get(secondNum)};
            }
            numMap.put(nums[i],i);
        }
        return new int[]{};
    }
}
