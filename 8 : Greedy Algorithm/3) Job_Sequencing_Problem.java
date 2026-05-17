public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=deadline.length;
        ArrayList<Integer> ans = new ArrayList<>();
        List<int[]> jobs = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            jobs.add(new int[]{deadline[i],profit[i]});
        }
        
        jobs.sort((a,b) -> (a[0]-b[0]));
        
        for(int i=0;i<n;i++){
            int[] job = jobs.get(i);
            
            if(pq.size() < job[0]){
                pq.add(job[1]);
            }
            else if(!pq.isEmpty() && pq.peek() < job[1]){
                pq.poll();
                pq.add(job[1]);
            }
        }
        
        int count = 0, totalProfit = 0;
        
        while(!pq.isEmpty()){
            count++;
            totalProfit += pq.poll();
        }
        
        ans.add(count);
        ans.add(totalProfit);
        return ans;
    }  
