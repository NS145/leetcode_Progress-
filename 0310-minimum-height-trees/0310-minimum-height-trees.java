class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if(n == 0) return result;
        if(n == 1){
            result.add(0);
            return result;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] degrees = new int[n];
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList());
        }

            for(int[] edge : edges){
                int node1 = edge[0];
                int node2 = edge[1];

                adj.get(node1).add(node2);
                adj.get(node2).add(node1);
            }

        for(int i=0; i<n; i++){
            degrees[i] = adj.get(i).size();
            if(degrees[i] == 1){
                q.offer(i);
            }
        }

        int remaining = n;
        while(remaining > 2){
            int size = q.size();
            remaining -= size;

            for(int i=0; i<size; i++){
                int leaf = q.poll();

                for(int nei : adj.get(leaf)){
                    degrees[nei]--;

                    if(degrees[nei] == 1){
                        q.offer(nei);
                    }
                }
            }
        }
        return new ArrayList(q);
    }
}