class Solution {
    private void permutate(List<List<Integer>> arr,List<Integer> ar,int index){
        if(index==ar.size()){
            if(!arr.contains(ar)){
                arr.add(new ArrayList<>(ar));
            }
            return;
        }
        for(int i=index;i<ar.size();i++){
            swap(ar,i,index);
            permutate(arr,ar,index+1);
            swap(ar,i,index);
        }
    }
    private List<Integer> swap(List<Integer> ar,int i,int j){
        int temp=ar.get(i);
        ar.set(i,ar.get(j));
        ar.set(j,temp);
        return ar;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ar=new ArrayList<>();
        for(int num:nums){
            ar.add(num);
        }
        List<List<Integer>> arr=new ArrayList<>();
        permutate(arr,ar,0);
        return arr;
    }
}