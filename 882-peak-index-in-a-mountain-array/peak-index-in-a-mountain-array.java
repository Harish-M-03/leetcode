class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int maxi=arr[0],ans=-1;
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(maxi<arr[mid]){
                maxi=arr[mid];
                ans=mid;
            }if(arr[mid]<arr[mid+1]&&mid+1<arr.length){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}