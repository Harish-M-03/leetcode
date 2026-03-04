class Solution {
    public int numSpecial(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        int res=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==1){
                    int rowcount=0;
                    int colcount=0;
                    for(int k=0;k<cols;k++){
                        if(mat[i][k]==1){
                            rowcount++;
                        }
                    }
                    for(int k=0;k<rows;k++){
                        if(mat[k][j]==1){
                            colcount++;
                        }
                    }
                    if(rowcount==1&&colcount==1){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}