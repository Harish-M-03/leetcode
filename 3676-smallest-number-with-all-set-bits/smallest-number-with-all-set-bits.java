class Solution {
    private boolean isSame(int num){
        String str=Integer.toBinaryString(num);
        HashSet<Character> set=new HashSet<>();
        for(char ch:str.toCharArray()){
            set.add(ch);
        }
        return set.size()==1; 
    }
    public int smallestNumber(int n) {
        while(true){
            if(isSame(n)){
                return n;
            }
            n++;
        }
    }
}