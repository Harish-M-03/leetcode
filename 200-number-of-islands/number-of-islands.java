class Solution {
    private void isIsland(int row,int col,char[][] grid,boolean[][] visited){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||visited[row][col] || grid[row][col] == '0'){
            return;
        }
        visited[row][col]=true;
        isIsland(row-1,col,grid,visited);
        isIsland(row+1,col,grid,visited);
        isIsland(row,col-1,grid,visited);
        isIsland(row,col+1,grid,visited);
    }
    public int numIslands(char[][] grid) {
        int row=grid.length,col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    isIsland(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
}