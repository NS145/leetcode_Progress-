class Solution {
    int[][] directions = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][]grid, int i, int j){
        if(i<0 || j<0 || i>= grid.length || j >= grid[0].length || grid[i][j]==0){
            return 0;
        }
            grid[i][j]=0;
            int area = 1;
            for(int[] dir : directions){
                area += dfs(grid, i+dir[0], j+dir[1]);
            }
        return area;
    }  
}