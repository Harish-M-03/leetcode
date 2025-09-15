class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] str=text.split(" ");
        ArrayList<Character> arr=new ArrayList<>();
        for(char ch:brokenLetters.toCharArray()){
            arr.add(ch);
        }
        int count=0;
        for(String st:str){
             boolean isfound=true;
            for(char ch:arr){
                if(st.indexOf(ch)!=-1){
                    isfound=false;
                    break;
                }
            }
            if(isfound){
                count++;
            }
        }
        return count;
    }
}