class Solution {
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
       
       for(int i=0; i<rows; i++){
        if(board[i][0]=='O' && visited[i][0]==false){
            dfs(board, i, 0, visited);
        }
        
        if(board[i][cols-1]=='O' && visited[i][cols-1]==false){
            dfs(board, i, cols-1, visited);
        }
       }

       for(int j=0; j<cols; j++){
        if(board[0][j]=='O' && visited[0][j]==false){
            dfs(board, 0, j, visited);
        }

        if(board[rows-1][j]=='O' && visited[rows-1][j]==false){
            dfs(board, rows-1, j, visited);
        }
       }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O' && visited[i][j]==false){
                    board[i][j] = 'X';
                }
            }
        }
    }
    void dfs(char[][] board, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true || board[i][j]=='X'){
            return;
        }

        visited[i][j] = true;

        for(int[] dir : directions){
            dfs(board, i+dir[0], j+dir[1], visited);
        }
    }
}