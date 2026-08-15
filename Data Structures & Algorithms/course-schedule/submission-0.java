class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
        }
        boolean[] visited = new boolean[n];
        boolean[] pathvisited = new boolean[n];

        for(int i = 0;i < n;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathvisited)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,boolean[] pathvisited){
        visited[node] = true;
        pathvisited[node] = true;

        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,pathvisited)){
                    return true;
                }
            }
            else if(pathvisited[neighbour]){
                return true;
            }
        }

        pathvisited[node] = false;
        return false;
    }
}
