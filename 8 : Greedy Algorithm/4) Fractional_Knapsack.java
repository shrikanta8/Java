public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        
        int n = val.length;
        double ans = 0, cap = 0;
        
        int[][] res = new int[n][2];
        
        for(int i=0;i<n;i++){
            res[i][0] = val[i];
            res[i][1] = wt[i]; 
        }
        
        Arrays.sort(res,(a,b) -> {
            double r1 = a[0]*1.0/a[1];
            double r2 = b[0]*1.0/b[1];
            
            return Double.compare(r2,r1);
        });
        
        for(int i=0;i<n;i++){
            if(cap + res[i][1] <= capacity ){
                ans += res[i][0];
            }
            else{
                ans += (res[i][0]*1.0/res[i][1]) * (capacity-cap);
                break;
            }
            cap += res[i][1];
        }
        
        return ans;
    }
