class Solution {
    boolean found = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(graph, vis, source, destination);
        return found;
    }
    void dfs(Map<Integer, List<Integer>> graph, boolean[] vis, int start, int end){
        if(vis[start] || found) return;
        vis[start] = true;
        for(int nei : graph.get(start)){
            if(nei == end){
                found = true;
                break;
            }
            if(!vis[nei]){
                dfs(graph, vis, nei, end);
            }
        }
    }
}