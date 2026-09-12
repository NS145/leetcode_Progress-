class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        // flag matrix for checking if the cell is visited 
        boolean[][] vis = new boolean[row][col];

        // DFS from first col and last col in the matrix 
        for(int i=0; i<row; i++){
            // first row 
            if(board[i][0]=='O' && vis[i][0]==false){
                dfs(i, 0, board, vis);
            }
            // last row
            if(board[i][col-1]=='O' && vis[i][col-1]==false){
                dfs(i, col-1, board, vis);
            }
        }

        //DFS from first row and last row 
        for(int j=0; j<col; j++){
            //first col
            if(board[0][j]=='O' && vis[0][j]==false){
                dfs(0, j, board, vis);
            }
            // last col
            if(board[row-1][j]=='O' && vis[row-1][j]==false){
                dfs(row-1, j, board, vis);
            }
        }

        // turning O to X if inside the board and not touching the borders 
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]=='O' && vis[i][j]==false){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int i, int j, char board[][], boolean vis[][]){
        int row = board.length;
        int col = board[0].length;

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        if(i<0 || j<0 || i>=row || j>=col || vis[i][j]==true || board[i][j]=='X'){
            return;
        }

        vis[i][j] = true;

        for(int[] dir : directions){
            dfs(i + dir[0], j + dir[1], board, vis);
        }
    }
}