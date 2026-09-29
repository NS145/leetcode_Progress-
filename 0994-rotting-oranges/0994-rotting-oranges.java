class Solution {
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i, j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int minutes = 0;
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] currFruit = q.poll();
                int curri = currFruit[0];
                int currj = currFruit[1];

                for(int[] dir : directions){
                    int ni = curri + dir[0];
                    int nj = currj + dir[1];

                    if(ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length){
                        continue;
                    }

                    if(grid[ni][nj] == 1){
                        q.offer(new int[]{ni, nj});
                        grid[ni][nj] = 2;
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}