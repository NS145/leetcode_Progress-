class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> req = new ArrayList<>();
        for(int i=0; i<n; i++){
            req.add(new ArrayList());
        }

        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(int connect : graph[i]){
                req.get(connect).add(i);
                indegree[i] = graph[i].length;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result.add(curr);

            for(int node : req.get(curr)){
                indegree[node]--;
                if(indegree[node] == 0) queue.offer(node);
            }
        }
        Collections.sort(result);
        return result;
    }
}