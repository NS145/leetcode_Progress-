class Solution {
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}}; 
    public boolean containsCycle(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!vis[i][j] && dfs(i, j, -1, -1, grid, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i, int j, int pi, int pj, char[][] grid, boolean[][] vis){
        vis[i][j] = true;

        int row = grid.length;
        int col = grid[0].length;

        for(int[] dir : directions){
            int ni = i + dir[0];
            int nj = j + dir[1];

              if(ni<0 || nj<0 || ni>=row || nj>=col){
                continue;
            }

            if(grid[ni][nj] != grid[i][j]){
                continue; 
            }

            if(ni == pi && nj == pj){
                continue;
            }

            if(vis[ni][nj]){
                return true;
            }

            if(dfs(ni, nj, i, j, grid, vis)){
                return true;
            }
        }
        return false;
    }
}