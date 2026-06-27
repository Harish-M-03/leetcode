class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:stones){
            arr.add(num);
        }
        while(arr.size()>1){
            ArrayList<Integer> ind=new ArrayList<>();
            int k=2;
            while(k!=0){
                int maxi=Integer.MIN_VALUE;
                int index=0;
                for(int i=0;i<arr.size();i++){
                    if(maxi<arr.get(i)){
                        maxi=arr.get(i);
                        index=i;
                    }
                }
                ind.add(maxi);
                arr.remove(index);
                k--;
            }
            int result=ind.get(0)-ind.get(1);
            if(result!=0){
                arr.add(result);
            }
        }
        return arr.isEmpty() ? 0 : arr.get(0);
    }
}