    class Triple{
        int row,col,dist;
        public Triple(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;

        }
    }
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Triple> q = new LinkedList<>();
        int[][] vist = new int[n][m];
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Triple(i,j,0));
                    vist[i][j]=1;
                    dist[i][j]=0;

                }else{
                    vist[i][j]=0;
                }

            }
        }
        int drow[] ={-1,0,+1,0};
        int dcol[] ={0,+1,0,-1};
        while(!q.isEmpty()){
            int r= q.peek().row;
            int c = q.peek().col;
            int d = q.peek().dist;
            q.remove();
            dist[r][c]=d;
             for(int k=0;k<4;k++){
                 int nrow = r+drow[k];
                 int ncol = c+dcol[k];
                 if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vist[nrow][ncol]==0){
                     vist[nrow][ncol]=1;
                     q.add(new Triple(nrow,ncol,d+1));


                 }
             }
        }
        return dist;
        
    }
}
