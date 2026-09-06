class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int k=0;
       for(int i=m;i<m+n;i++){
            nums1[i]=nums2[k++];
       }
       for(int i=1;i<m+n;i++){
            int j=i-1;
            int key=nums1[i];
            while(j>=0&&nums1[j]>=key){
                nums1[j+1]=nums1[j];
                j=j-1;
            }
            nums1[j+1]=key;
       }
    }
}