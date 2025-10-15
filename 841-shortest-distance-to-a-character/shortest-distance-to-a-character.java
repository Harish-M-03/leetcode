class Solution {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                arr.add(i);
            }
        }
        int[] result=new int[s.length()];
        for(int i=0;i<s.length();i++){
            int mini=Integer.MAX_VALUE;
            for(int j=0;j<arr.size();j++){
                int diff=Math.abs(i-arr.get(j));
                mini=Math.min(mini,diff);
            }
            result[i]=mini;
        }
        return result;
    }
}