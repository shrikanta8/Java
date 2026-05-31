class Solution {
    public String getPermutation(int n, int k) {
        List<Integer>  arr = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        int fact = 1;
        k=k-1;

        for(int i=1;i<n;i++){
            arr.add(i);
            fact *= i;
        }
        arr.add(n);

        while(true){
            int ind = k/fact;

            ans.append(arr.get(ind));
            arr.remove(ind);
            int sz = arr.size();
            if(sz==0){
                break;
            }

            k %= fact;
            fact /= sz;

        }
        return ans.toString();
    }
}
