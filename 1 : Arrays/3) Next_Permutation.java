import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] arr = {1,5,3,2,4};
		
		sol.nextPermutation(arr);
	    System.out.println(Arrays.toString(arr));
		
	}
}

class Solution {
    public void nextPermutation(int[] nums) {
        int maxIndex=0,minIndex=0;
        int n = nums.length, i=0;

        for(i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                minIndex = i-1;
                break;
            }
        }

        if(i==0){
            reverse(nums, 0, n-1);
            return;
        }

        for(int j=n-1;j>=0;j--){
            if(nums[j]>nums[minIndex]){
                maxIndex = j;
                break;
            }
        }
        swap(nums, minIndex, maxIndex);
        reverse(nums, minIndex+1,n-1);
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int start, int end){
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
}


