class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
        boolean[][] visited=new boolean[n][n];
        visited[0][0] = true; 
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        int[] drow = {-1,-1,-1,0,0,1,1,1};
        int[] dcol = {-1,0,1,-1,1,-1,0,1};
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int row=cur[0];
            int col=cur[1];
            int dist=cur[2];
            if(row==n-1&&col==n-1){
                return dist;
            }
            for(int i=0;i<8;i++){
                int nr=row+drow[i];
                int nc=col+dcol[i];
                if(nr>=0&&nc>=0&&nr<n&&nc<n&&grid[nr][nc]==0&&!visited[nr][nc]){
                    queue.offer(new int[]{nr,nc,dist+1});
                    visited[nr][nc]=true;
                }
            }
        }
        return -1;
    }
}