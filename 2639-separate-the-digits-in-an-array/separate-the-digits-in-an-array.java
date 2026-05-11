class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:nums){
            String str=Integer.toString(num);
            for(char ch:str.toCharArray()){
                arr.add(ch-'0');
            }
        }
        int[] result=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            result[i]=arr.get(i);
        }
        return result;
    }
}