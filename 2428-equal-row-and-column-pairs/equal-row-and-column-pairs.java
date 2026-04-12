class Solution {
    private boolean isEqual(int row,int col,int[][] grid){
        ArrayList<Integer> ar1=new ArrayList<>();
        ArrayList<Integer> ar2=new ArrayList<>();
        for(int i=0;i<grid[0].length;i++){
            ar1.add(grid[row][i]);
        }
        for(int i=0;i<grid.length;i++){
            ar2.add(grid[i][col]);
        }
        return ar1.equals(ar2);  
    }
    public int equalPairs(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(isEqual(i,j,grid)){
                    count++;
                }
            }
        }
        return count;
    }
}