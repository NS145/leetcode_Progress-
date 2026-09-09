class Solution {
    private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}}; 
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int i, int j){
            if(i < 0 || j < 0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
                return;
            }
            for(int[] d : directions){
                grid[i][j] = '0';    
                dfs(grid, i + d[0], j + d[1]);
            }
    }
}