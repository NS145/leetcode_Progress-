class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1) fresh++;
            }
        }

        while(fresh > 0){
            boolean flag = false;
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(grid[i][j]==2){
                        for(int[] d : directions){
                            int currRow = i + d[0];
                            int currCol = j + d[1];
                            if(currRow >= 0 && currCol >= 0 &&
                                currRow < rows && currCol < cols &&
                                grid[currRow][currCol]==1){
                                    grid[currRow][currCol] = 3;
                                    fresh--;
                                    flag = true;
                                }
                        }
                    }
                }
            }
            if(!flag) return -1;

            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(grid[i][j]==3){
                        grid[i][j]=2;
                    }
                }
            }
            time++;
        }
        return time;
    }
}