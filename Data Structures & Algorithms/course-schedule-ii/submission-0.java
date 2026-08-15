class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //topological dfs + cycle detetction
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
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                if(dfs(i,visited,pathvisited,adj,stack)){
                    return new int[0];
                }
            }
        }
        int[] ans = new int[n];
        for(int i = 0;i < n;i++){
            ans[i] = stack.pop();
        }
        return ans;
    }

    private boolean dfs(int node,boolean[] visited,boolean[] pathvisited,List<List<Integer>> adj,Deque<Integer> stack){
        visited[node] = true;
        pathvisited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,visited,pathvisited,adj,stack)){
                    return true;
                }
            }else if(pathvisited[neighbour]){
                return true;
            }
        }
        stack.push(node);
        pathvisited[node] = false;
        return false;
    }
}
