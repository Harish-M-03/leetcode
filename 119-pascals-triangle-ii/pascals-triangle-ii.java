class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> ar=new ArrayList<>();
            ar.add(1);
            for(int j=1;j<=i;j++){
                if(i==j){
                    ar.add(1);
                }else{
                    int num=arr.get(i-1).get(j-1)+arr.get(i-1).get(j);
                    ar.add(num);
                }
            }
            arr.add(ar);
        }
        return arr.get(rowIndex);
    }
}