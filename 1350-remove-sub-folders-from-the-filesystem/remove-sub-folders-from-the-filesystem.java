class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res=new ArrayList<>();
        Arrays.sort(folder);
        for(String st:folder){
            if(res.isEmpty()){
                res.add(st);
            }else{
                String prev=res.get(res.size()-1);
                if(st.startsWith(prev)&&st.length()>prev.length()&&st.charAt(prev.length())=='/'){
                    continue;
                }else{
                    res.add(st);
                }
            }
        }
        return res;
    }
}