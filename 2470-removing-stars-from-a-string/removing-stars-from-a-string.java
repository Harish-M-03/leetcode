class Solution {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty()&&ch=='*'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        String str="";
        if(!stack.isEmpty()){
            for(char ch:stack){
                str+=ch;
            }
        }
        return str;
    }
}