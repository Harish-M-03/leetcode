class Solution {
    public String decodeString(String s) {
        Stack<String> alphabet = new Stack<>();
        Stack<Integer> number = new Stack<>();
        
        String str = "";
        int num = 0;
        
        for(char ch : s.toCharArray()){
            
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0'); 
            }
            else if(ch == '['){
                number.push(num);
                alphabet.push(str);
                num = 0;
                str = "";
            }
            else if(ch == ']'){
                int count = number.pop();
                String prev = alphabet.pop();
                
                String temp = "";
                for(int i = 0; i < count; i++){
                    temp += str;
                }
                
                str = prev + temp;
            }
            else{
                str += ch;
            }
        }
        
        return str;
    }
}