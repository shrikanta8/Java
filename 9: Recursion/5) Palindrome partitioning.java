class Solution {
    boolean isPalindrome(String str, int n){
        int st = 0;
        while(st<n){
            if(str.charAt(st) != str.charAt(n)){
                return false;
            }
            st++;n--;
        }
        return true;
    }

    void partitionHelper(String s, List<List<String>> result, List<String> current, int ind, int n){
        if(ind == n){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=ind;i<n;i++){
            String str = s.substring(ind,i+1);
            if(isPalindrome(str,i-ind)){
                current.add(str);
                partitionHelper(s,result,current, i+1,n);
                current.remove(current.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        
        int n = s.length();

        List<List<String>> result = new ArrayList<>();
        partitionHelper(s,result, new ArrayList<String>(),0,n);
        return result;   
    }
}
