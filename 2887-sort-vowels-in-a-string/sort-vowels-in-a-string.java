class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> arr=new ArrayList<>();
        ArrayList<Integer> num=new ArrayList<>();
        ArrayList<Character> arr1=new ArrayList<>();
        arr.add('a');
        arr.add('e');
        arr.add('i');
        arr.add('o');
        arr.add('u');
        arr.add('A');
        arr.add('E');
        arr.add('I');
        arr.add('O');
        arr.add('U');
        for(int i=0;i<s.length();i++){
            if(arr.contains(s.charAt(i))){
                num.add(i);
                arr1.add(s.charAt(i));
            }
        }
        Collections.sort(arr1);
        StringBuilder result = new StringBuilder(s);
        for(int i=0;i<num.size();i++){
            result.setCharAt(num.get(i), arr1.get(i));
        }
        return result.toString(); 
    }
}