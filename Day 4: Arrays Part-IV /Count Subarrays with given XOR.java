class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        
        int xorVal=0,subArrayCount=0;
        
        for(int ele:arr){
            
            xorVal^=ele;
            
            subArrayCount += map.getOrDefault(xorVal^k,0);
            
            map.put(xorVal, map.getOrDefault(xorVal,0)+1);
            
        }   
        
        return subArrayCount;
    }
}

// xorVal=x^k

// xorVal^k=x

// we are serching for this x  
