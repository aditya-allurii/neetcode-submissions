class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < n;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        int[] ans = new int[n];
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans[count++] = node;
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        if(count != n){
            return new int[0];
        }
        return ans;
    }
}
