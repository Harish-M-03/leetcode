class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minidiff=Integer.MAX_VALUE;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            minidiff=Math.min(minidiff,arr[i]-arr[i-1]);
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==minidiff){
                List<Integer> ar=new ArrayList<>();
                ar.add(arr[i-1]);
                ar.add(arr[i]);
                res.add(ar);
            }
        }
        return res;
    }
}