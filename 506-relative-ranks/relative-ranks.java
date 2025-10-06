class Solution {
    public String[] findRelativeRanks(int[] score) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:score){
            arr.add(num);
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        HashMap<Integer,String> map=new HashMap<>();
        int i=0;
        while(i<arr.size()){
            if(i==0){
                map.put(arr.get(i),"Gold Medal");
            }else if(i==1){
                map.put(arr.get(i),"Silver Medal");
            }
            else if(i==2){
                map.put(arr.get(i),"Bronze Medal");
            }else{
                map.put(arr.get(i),Integer.toString(i+1));
            }
            i++;
        }
        String[] res=new String[score.length];
        for(int j=0;j<score.length;j++){
            res[j]=map.get(score[j]);
        }
        return res;
    }
}