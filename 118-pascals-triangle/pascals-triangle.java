class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> ar=new ArrayList<>();
            ar.add(1);
            for(int j=1;j<=i;j++){
                if(j==i){
                    ar.add(1);
                }else{
                    int num=arr.get(i-1).get(j-1)+arr.get(i-1).get(j);
                    ar.add(num);
                }
            }
            arr.add(new ArrayList<>(ar));;
        }
        return arr;
    }
}