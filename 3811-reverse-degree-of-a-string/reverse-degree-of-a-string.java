class Solution {
    public int reverseDegree(String s) {
        int product=0;
        int index=1;
        for(char ch:s.toCharArray()){
            int num=((122-((int)ch))+1)*index;
            product=product+num;
            index++;
        }
        return product;
    }
}