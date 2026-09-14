class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int curNode = q.poll();
            
            if(curNode == destination){
                return true;
            }

            for(Integer neighbour : adj.get(curNode)){
                if(!visited[neighbour]){
                    q.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return false;
    }
}