class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxi=arr1[0];
        for(int num:arr1){
            maxi=Math.max(maxi,num);
        }
        int[] freq=new int[maxi+1];
        for(int num:arr1){
            freq[num]++;
        }
        int[] result=new int[arr1.length];
        int k=0;
        for(int num:arr2){
            int n=freq[num];
            for(int i=0;i<n;i++){
                result[k++]=num;
            }
            freq[num]=0;
        }
        for(int i = 0; i < freq.length; i++){

            while(freq[i] > 0){

                result[k++] = i;

                freq[i]--;
            }
        }
        return result;
    }
}