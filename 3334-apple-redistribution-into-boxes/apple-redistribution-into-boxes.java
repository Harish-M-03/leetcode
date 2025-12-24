class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
       ArrayList<Integer> arr=new ArrayList<>();
       for(int num:capacity){
            arr.add(num);
       }
       int total=0;
       for(int num:apple){
            total+=num;
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        int boxes=0;
        int tot=0;
        for(int num:arr){
            tot+=num;
            boxes++;
            if(tot>=total){
                return boxes;
            }
        }
    return boxes;   
    }
}