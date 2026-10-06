class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] currCell = q.poll();
                int celli = currCell[0];
                int cellj = currCell[1];

                int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
                for(int[] dir : directions){
                    int nextCelli = celli + dir[0];
                    int nextCellj = cellj + dir[1];

                    if(nextCelli < 0 || nextCellj < 0 || nextCelli >= rows || nextCellj >= cols){
                        continue;
                    }

                    if(grid[nextCelli][nextCellj] == 1){
                        q.offer(new int[]{nextCelli, nextCellj});
                        grid[nextCelli][nextCellj] = 2;
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        if(fresh == 0){
            return minutes;
        }else{
            return -1;
        }
    }
}