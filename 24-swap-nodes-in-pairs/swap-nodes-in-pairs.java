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
    public ListNode swapPairs(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode temp=head;
        ListNode dummy=new ListNode(-1);
        ListNode ptr=dummy;
        while(temp!=null){
            stack.push(temp.val);
            if(stack.size()==2){
                while(!stack.isEmpty()){
                    ptr.next=new ListNode(stack.pop());
                    ptr=ptr.next;
                }
            }
            temp=temp.next;
        }
        while(!stack.isEmpty()){
            ptr.next=new ListNode(stack.pop());
            ptr=ptr.next;
        }
        return dummy.next;
    }
}