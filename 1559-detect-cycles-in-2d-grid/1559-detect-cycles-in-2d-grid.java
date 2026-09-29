class Solution {
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!visited[i][j]){
                    if(dfs(grid, i, j, -1, -1, visited)) return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] grid, int i, int j, int pi, int pj, boolean[][] visited){
        visited[i][j] = true;

        for(int[] dir : directions){
            int ni = i + dir[0];
            int nj = j + dir[1];

            if(ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length){
                continue;
            }

            if(grid[i][j] != grid[ni][nj]){
                continue;
            }

            if(ni == pi && nj == pj){
                continue;
            }
            
            if(visited[ni][nj]){
                return true;
            }

            if(dfs(grid, ni, nj, i, j, visited)){
                return true;
            }
        }
        return false;
    }
}