class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;

        if(l1 > l2){
            return findMedianSortedArrays(nums2,nums1);
        }

        int start = 0, end = l1-1;
        int totalCount = (l1+l2)/2;
        double ans = 0;
        while(true){
            int index1 = start + (end - start)/2;
            int index2 = totalCount - index1;

            int left1 = index1 == 0 ? Integer.MIN_VALUE : nums1[index1-1];
            int right1 = index1 == l1 ? Integer.MAX_VALUE : nums1[index1];
            int left2 = index2 == 0 ? Integer.MIN_VALUE : nums2[index2-1];
            int right2 = index2 == l2 ? Integer.MAX_VALUE : nums2[index2];

            if(left1 <= right2 && left2 <=right1){
                if((l1+l2)%2!=0){
                    ans = Math.min(right1,right2);
                }
                else
                    ans = (double)(Math.max(left1,left2)+Math.min(right1,right2))/2;
                break;
            }
            else if(left1 >right2){
                end = index1 - 1;
            }
            else{
                start = index1 + 1;
            }
        }
        return ans;
    }
}
