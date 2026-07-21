class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0,minutes=0;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            boolean isRotten=false;
            int size=queue.size();
            while(size-->0){
                int[] cur=queue.poll();
                for(int[] d:dir){
                    int nr=d[0]+cur[0];
                    int nc=d[1]+cur[1];
                    if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        queue.offer(new int[]{nr,nc});
                        fresh--;
                        isRotten=true;
                    }
                }
            }
            if(isRotten){
                minutes++;
            }
        }
        return fresh==0?minutes:-1;
    }
}