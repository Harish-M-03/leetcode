/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp=head;
        ArrayList<Integer> arr=new ArrayList<>();
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        int[] res=new int[arr.size()];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.size();i++){
            while(!stack.isEmpty()&&arr.get(i)>arr.get(stack.peek())){
                res[stack.pop()]=arr.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}