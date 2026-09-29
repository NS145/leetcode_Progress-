class Solution {
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    void dfs(int[][] image, int sr, int sc, int color, int currImage){
        if(sr < 0 || sc < 0 || sr >=image.length || sc >= image[0].length){
            return;
        }

        if(image[sr][sc] != currImage){
            return;
        }

        image[sr][sc] = color;

        for(int[] dir : directions){
            dfs(image, sr + dir[0], sc + dir[1], color, currImage);
        }
    }
}