class Pair {
        int row, col, tm;

        public Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
}
class Solution {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int [][] vist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vist[i][j]=2;

                }else{
                    vist[i][j]=0;
                }
                

            }
        }
        int tm =0;
        int drow[]={-1,0,+1,0};
        int dcol[] ={0,+1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(t,tm);
            q.remove();
            for(int k=0;k<4;k++){
                int nrow = r+drow[k];
                int ncol = c+dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vist[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol,t+1));
                    vist[nrow][ncol]=2;
                }
            }


        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vist[i][j]!=2 && grid[i][j]==1) return -1;
            }
        }
        return tm;
    }
}
