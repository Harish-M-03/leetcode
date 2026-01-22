class Solution {
    private boolean isSorted(ArrayList<Integer> arr){
        boolean isValid=true;
        for(int i=1;i<arr.size();i++){
                if(arr.get(i-1)>arr.get(i)){
                    isValid=false;
                    break;
                }
            }
            return isValid;
    }
    public int minimumPairRemoval(int[] nums) {
        int count=0;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:nums){
            arr.add(num);
        }
        if(isSorted(arr)){
            return 0;
        }
        boolean isValid=false;
        while(!isValid){
            int mini=Integer.MAX_VALUE;
            int index0=-1,index1=-1;
            for(int i=1;i<arr.size();i++){
                int sum=arr.get(i)+arr.get(i-1);
                if(mini>sum){
                    mini=sum;
                    index0=i-1;
                    index1=i;
                }
            }
            arr.set(index0,mini);
            arr.remove(index1);
            count++;
            if(isSorted(arr)){
                isValid=true;
            }
        }
        return count;
    }
}