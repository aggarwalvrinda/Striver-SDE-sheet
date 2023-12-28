class Solution {
    void dfs(int row,int col, int[][] ans, int[][] image, int color, int[] drow, int[] dcol, int intialColor){
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int newrow = row + drow[i];
            int newcol = col + dcol[i];
            if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && image[newrow][newcol] == intialColor && ans[newrow][newcol] != color){
                dfs(newrow,newcol,ans, image,color,drow,dcol,intialColor);
            }
            
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int intialColor = image[sr][sc];
        int[][] ans = image; //copy the orignal data
        int drow[] ={-1,0,+1,0};
        int dcol[] ={0,+1,0,-1};
        dfs(sr,sc, ans,image, color,drow,dcol,intialColor);
        return ans;
        
    }
}
