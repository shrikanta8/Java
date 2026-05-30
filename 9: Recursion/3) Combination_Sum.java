class Solution {
    void combinationSumHelper(int[] candidates, int target, int ind, List<Integer> current,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if( ind == candidates.length){
            return;
        }

        if(candidates[ind] <= target){
            current.add(candidates[ind]);
            combinationSumHelper(candidates, target-candidates[ind],ind,current,result);
            current.remove(current.size() - 1);
        }

        combinationSumHelper(candidates, target, ind+1, current, result);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target,0, new ArrayList<>(), result);
        return result;
    }
}
