class Solution {
    
    static int mergeArrays(int[] arr, int st, int mid, int en){
        
        int[] temp = new int[en-st+1];
        
        int left = st, right = mid, i = 0, k = 0;
        int ans = 0;
        
        while(left < mid && right <= en){
            if(arr[left] <= arr[right]){
                temp[i++] = arr[left++];
            }
            else{
                temp[i++] = arr[right++];
                ans += (mid-left);
            }
        }
        
        while(left < mid){
            temp[i++] = arr[left++];
        }
        
        while(right <= en ){
            temp[i++] = arr[right++];
        }
        
        for(int j=st;j<=en;j++){
            arr[j] = temp[k++];
        }
        
        return ans;
    }
    
    
    static int inversionCountHelper(int[] arr, int st, int en){
        if(st>=en){
            return 0;
        }
        
        int ans=0;
        int mid = st + (en-st)/2;
        
        ans += inversionCountHelper(arr,st,mid);
        ans += inversionCountHelper(arr,mid+1,en);
        ans += mergeArrays(arr,st,mid+1,en);
        
        return ans;
    }
    static int inversionCount(int arr[]) {
        // Code Here
        return inversionCountHelper(arr,0,arr.length-1);
    }
}
