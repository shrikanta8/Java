class Solution {
    void permuteHelper(int[] nums, List<List<Integer>> result, boolean[] visit, List<Integer> current, int n ){
        if(current.size() == n){
            result.add(new ArrayList<>(current));
        }
        else{
            for(int i=0;i<n;i++){
                if(visit[i]==true)    
                    continue;
                visit[i] = true;
                current.add(nums[i]);
                permuteHelper(nums,result, visit,current,n);
                current.remove(current.size()-1);
                visit[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums,result,new boolean[n],new ArrayList<>(),n);
        return result;
    }
}
