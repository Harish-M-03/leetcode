class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp=arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> map=new HashMap<>();
        int rank=1;
        for(int i=0;i<temp.length;i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i],rank++);
            }
        }
        int[] result=new int[arr.length];
        int k=0;
        for(int num:arr){
            result[k++]=map.get(num);
        }
        return result;
    }
}