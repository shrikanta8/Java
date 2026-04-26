class Solution {
    public double myPow(double x, int n) {

        long p = n; // long for -2147483648
        double ans = 1;

        if(p < 0){
            p *= -1;
        }
        while(p > 0){
            if(p % 2 == 0){
                p /= 2;
                x = x * x;
            }
            else{
                p--;
                ans = ans * x;
            }
        }

        if(n < 0){
            return (double)1/ans;
        }
        return ans;
    }

}
