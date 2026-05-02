class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] orderCourses = new int[numCourses];
        int idx = 0;

        List<List<Integer> > adj = new ArrayList<>();
        Queue<Integer> qu = new LinkedList<>();

        for(int i=1;i<=numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            int src = pre[1], dest = pre[0];
            adj.get(src).add(dest);
            inDegree[dest]++;
        }

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                qu.offer(i);
            }
        }

        while(!qu.isEmpty()){
            int node = qu.poll();
            orderCourses[idx++] = node;

            for(int nei:adj.get(node)){
                inDegree[nei]--;
                if(inDegree[nei] == 0){
                    qu.offer(nei);
                }
            }
        }
        
        if(idx == numCourses){
            return orderCourses;
        }
        return new int[0];
    }
}
