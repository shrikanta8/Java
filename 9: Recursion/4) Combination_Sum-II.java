class Solution {

    void combinationSumHelper(int[] candidates, int target, int ind, List<List<Integer>> result, List<Integer> current){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=ind;i<candidates.length;i++){
            if( i!=ind && (candidates[i]==candidates[i-1]) ){
                continue;
            }
            if( target >= candidates[i]){
                current.add(candidates[i]);
                combinationSumHelper(candidates, target-candidates[i], i+1,result,current);
                current.remove(current.size() - 1);
            }
       }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, result, new ArrayList<>());
        return result;
    }
}
