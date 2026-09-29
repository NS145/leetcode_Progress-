class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totIslands = 0;

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int i=0; i<rows;i++){
            for(int j=0;j<cols; j++){
                if(grid[i][j] == '1'){
                    totIslands++;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});

                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];

                        for(int[] dir : directions){
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == '1'){
                                q.offer(new int[]{nr, nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return totIslands;
    }
}