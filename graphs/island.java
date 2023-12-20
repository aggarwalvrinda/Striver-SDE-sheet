class Solution {
    public void mark(char[][] matrix,int x,int y, int r, int c){
         if (x < 0 || x >= r || y < 0 || y >= c || matrix[x][y] != '1') {
            return;
        }
        matrix[x][y] = '2';
        mark(matrix, x-1, y,r, c); // top
        mark(matrix, x+1, y,r, c);// bottom
        mark(matrix, x, y-1,r , c);// left
        mark(matrix, x, y+1,r , c);// right
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if(row==0){
            return 0;
        }

        int island=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                mark(grid,i,j, row, col);
                 island++;
                }
                
            }
        }
        return island;
    }
}


// another code using bfs and visited 
