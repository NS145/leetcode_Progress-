class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for(int i=0; i<visited.length; i++){
            if(visited[i] == false){
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }
    void dfs(int curr, int[][] isConnected, boolean[] visited){
        visited[curr] = true;

        for(int i=0; i<visited.length; i++){
            if(isConnected[curr][i] == 1 && visited[i] == false){
                dfs(i, isConnected, visited);
            }
        }
    }
}