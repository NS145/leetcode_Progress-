class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> nodesIn = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            nodesIn.add(new ArrayList());
        }

        int[] outdegree = new int[n];
        for(int i=0; i<n; i++){
            for(int node : graph[i]){
                outdegree[i] = graph[i].length;
                nodesIn.get(node).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<outdegree.length; i++){
            if(outdegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int currNode = q.poll();
            result.add(currNode);

            for(int node : nodesIn.get(currNode)){
                outdegree[node]--;
                if(outdegree[node] == 0){
                    q.offer(node);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}