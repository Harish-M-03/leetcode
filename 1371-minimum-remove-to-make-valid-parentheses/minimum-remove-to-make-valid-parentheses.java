class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> numstack = new Stack<>();
        Stack<Character> chrstack = new Stack<>();
        HashSet<Integer> remove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                chrstack.push(ch);
                numstack.push(i);
            } 
            else if (ch == ')') {
                if (!chrstack.isEmpty() && chrstack.peek() == '(') {
                    chrstack.pop();
                    numstack.pop();
                } else {
                    remove.add(i); 
                }
            }
        }

        while (!numstack.isEmpty()) {
            remove.add(numstack.pop());
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove.contains(i)) {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}