class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int k=0;
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=k++;
            }
        }
        int index=0,i=0,j=0;
        while(index<commands.size()){
            String str=commands.get(index);
            if(str.equals("UP")){
                if(i>0){
                    i--;
                }
            }
            else if(str.equals("DOWN")){
                if(i<n){
                    i++;
                }
            }else if(str.equals("LEFT")){
                if(j>0){
                    j--;
                }
            }else if(str.equals("RIGHT")){
                if(j<n){
                    j++;
                }
            }
            index++;
        }
        return mat[i][j];
    }
}