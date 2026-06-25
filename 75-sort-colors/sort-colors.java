class Solution {
    private void merge(int[] nums,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            merge(nums,left,mid);
            merge(nums,mid+1,right);
            mergesort(nums,left,mid,right);
        }
    }
    private void mergesort(int[] nums,int left,int mid,int right){
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
        int j=0,l=0,k=left;
        while(j<n1&&l<n2){
            if(L[j]<=R[l]){
                nums[k++]=L[j++];
            }else{
                nums[k++]=R[l++];
            }
        }
        while(j<n1){
            nums[k++]=L[j++];
        }
        while(l<n2){
            nums[k++]=R[l++];
        }
    }
    public void sortColors(int[] nums) {
        merge(nums,0,nums.length-1);
    }
}