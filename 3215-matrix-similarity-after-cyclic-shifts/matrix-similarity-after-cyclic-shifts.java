class Solution {
    private void leftShift(ArrayList<Integer> arr,int k){
        int j=0;
        while(j<k){
            int first=arr.get(0);
            for(int i=0;i<arr.size()-1;i++){
                arr.set(i,arr.get(i+1));
            }
            arr.set(arr.size()-1,first);
            j++;
        }
    }
    private void rightShift(ArrayList<Integer> arr,int k){
        int j=0;
        while(j<k){
            int last=arr.get(arr.size()-1);
            for(int i=arr.size()-1;i>0;i--){
                arr.set(i,arr.get(i-1));
            }
            arr.set(0,last);
            j++;
        }
    }
    public boolean areSimilar(int[][] mat, int k) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<mat.length;i++){
            ArrayList<Integer> ar=new ArrayList<>();
            for(int j=0;j<mat[0].length;j++){
                ar.add(mat[i][j]);
            }
            arr.add(ar);
        }
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if(i%2==0){
                ArrayList<Integer> ar=new ArrayList<>(arr.get(i));
                leftShift(ar,k);
                res.add(ar);
            }else{
                ArrayList<Integer> ar=new ArrayList<>(arr.get(i));
                rightShift(ar,k);
                res.add(ar);
            }
        }
        return res.equals(arr);
    }
}