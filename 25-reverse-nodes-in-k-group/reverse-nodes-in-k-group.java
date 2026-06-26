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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead=new ListNode(-1);
        ListNode ptr=newHead;
        Stack<Integer> stack=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp.val);
            if(stack.size()==k){
                while(!stack.isEmpty()){
                    ptr.next=new ListNode(stack.pop());
                    ptr=ptr.next;
                }
            }
            temp=temp.next;
        }
        if(!stack.isEmpty()){
            for(int num:stack){
                ptr.next=new ListNode(num);
                ptr=ptr.next;
            }
        }
        return newHead.next;
    }
}