class Solution {
    private int[] merge(int[] num1,int[] num2){
        int[] result=new int[2];
        result[0]=Math.max(num1[0],num2[0]);
        result[1]=Math.min(num1[1],num2[1]);
        return result;
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int[][] result=new int[points.length][2];
        int k=0;
        result[k]=points[0];
        for(int i=1;i<points.length;i++){
            int[] num1=result[k];
            int[] num2=points[i];
            if(num1[1]<num2[0]){
                result[++k]=num2;
            }else{
                result[k]=merge(num1,num2);
            }
        }
        return k+1; 
    }
}