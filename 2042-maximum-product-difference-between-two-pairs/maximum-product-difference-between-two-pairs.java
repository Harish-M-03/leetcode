class Solution {
    private void mergeSort(int[] nums,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }
    private void merge(int[] nums,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=nums[left+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=nums[mid+i+1];
        }
        int m=0,n=0,k=left;
        while(m<n1&&n<n2){
            if(L[m]<=R[n]){
                nums[k++]=L[m++];
            }else{
                nums[k++]=R[n++];
            }
        }
        while(m<n1){
            nums[k++]=L[m++];
        }
        while(n<n2){
            nums[k++]=R[n++];
        }
    }
    public int maxProductDifference(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        int n=nums.length;
        int n1=nums[0]*nums[1];
        int n2=nums[n-2]*nums[n-1];
        return n2-n1;
    }
}