class Solution {
    public int findCircleNum(int[][] isConnected) {
     boolean[] visited = new boolean[isConnected.length];

     int count = 0;
    for(int i=0; i<isConnected.length; i++){
        if(visited[i] == false){
            dfs(i, visited, isConnected);
            count++;
        }
    } 
    return count;   
    }

    void dfs(int currNode, boolean[] visited, int[][] isConnected){
        visited[currNode] = true;

        for(int i=0; i<isConnected.length; i++){
            if(isConnected[currNode][i]==1 && visited[i] == false){
                dfs(i, visited, isConnected);
            }
        }
    }
}