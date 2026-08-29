class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
             map.putIfAbsent(nums[i], new LinkedList<>());
            map.get(nums[i]).add(i);
        }
        Arrays.sort(nums);
        int n=nums.length;
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        ArrayList<Integer> s=new ArrayList<>();
        s.add(nums[0]);
        for(int i=1;i<n;i++){
            if((nums[i]-nums[i-1])>limit){
                arr.add(new ArrayList<>(s));
                s.clear();
                s.add(nums[i]);
            }else{
                s.add(nums[i]);
            }
        }
        if(!s.isEmpty()){
            arr.add(new ArrayList<>(s));
        }
        int[] result=new int[nums.length];
        for(ArrayList<Integer> ar:arr){
            ArrayList<Integer> val=new ArrayList<>();
            ArrayList<Integer> ind=new ArrayList<>();
            for(int v:ar){
                val.add(v);
                ind.add(map.get(v).poll());
            }
                Collections.sort(val);
                Collections.sort(ind);
                for(int i=0;i<ind.size();i++){
                    result[ind.get(i)]=val.get(i);
                }
            }
        return result;
    }
}