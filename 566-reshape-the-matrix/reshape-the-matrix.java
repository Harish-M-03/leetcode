class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows=mat.length;
        int col=mat[0].length;
        if((rows*col)!=(r*c)){
            return mat;
        }
        int[][] output=new int[r][c];
        int output_rows=0;
        int output_cols=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
            output[output_rows][output_cols]=mat[i][j];
            output_cols++;
            if(output_cols==c){
                output_cols=0;
                output_rows++;
            }
        }
        }
        return output; 
    }
}