class Solution {
    public void duplicateZeros(int[] arr) {
        int[] zero=new int[arr.length];
        int j=0;
        for(int i=0;i<arr.length&&j<arr.length;i++){
            zero[j++]=arr[i];
            if(arr[i]==0&&j<arr.length){
                zero[j++]=0;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=zero[i];
        }
    }
}