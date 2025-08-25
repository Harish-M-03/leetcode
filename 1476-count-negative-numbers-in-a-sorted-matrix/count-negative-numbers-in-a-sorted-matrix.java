class Solution {
    public int countNegatives(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int ans=0;
        for(int i=0;i<row;i++){
            int left=0,right=col-1;
          while(left<=right){
            int mid=left+(right-left);
            if(grid[i][mid]<0){
                right=mid-1;
            }else{
                left=mid+1;
            }
         }
         ans+=(col-left);
        }
        return ans;
    }
}