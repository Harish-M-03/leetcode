class Solution {
    private boolean isSorted(int[] arr,int i,int n){
        boolean isSorted=true; 
        for(int j=i+1;j<i+n;j++){
            if(arr[j%n]<arr[(j-1)%n]){
                isSorted=false;
                break;
            }
        }
        return isSorted;
    }
    public boolean check(int[] nums) {
        boolean isValid=false;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(isSorted(nums,i,n)){
                isValid=true;
                break;
            }
        }
        return isValid;
    }
}