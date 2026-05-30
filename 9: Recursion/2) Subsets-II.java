class Solution {
    void backtrack(int ind, int[] nums, List<List<Integer>> result, List<Integer> arr ){
      
        result.add(new ArrayList<>(arr));
        
        for(int i=ind;i<nums.length;i++){
            if(i > ind && (nums[i] == nums[i-1]) ){
                continue;
            }

            arr.add(nums[i]);
            backtrack(i+1,nums,result,arr);
            arr.remove(arr.size() - 1);
            
        }
        
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,result,new ArrayList<>());

        return result;
    }
}


// O(2^N) time
