class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        if(operations.length==0){
            return 0;
        }
        for(String st:operations){
            if(st.equals("--X")){
                --x;
            }else if(st.equals("++X")){
                ++x;
            }else if(st.equals("X++")){
                x++;
            }else if(st.equals("X--")){
                x--;
            }
        }
        return x;
    }
}