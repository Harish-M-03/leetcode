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
    private static ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head; 
        }
        Stack<Integer> stack=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        ListNode newhead=head;
        ListNode ptr=newhead;
        while(!stack.isEmpty()){
            ptr.next=new ListNode(stack.pop());
            ptr=ptr.next;
        }
        return newhead.next;
    }
    public ListNode removeNodes(ListNode head) {
        if(head==null||head.next==null){
            return head; 
        }
        head=reverse(head);
        ListNode current=head;
        ListNode maxi=head;
        while(current.next!=null){
            if(current.next.val<maxi.val){
                current.next=current.next.next;
            }
            else{
                current=current.next;
                maxi=current;
            }
        }
        return reverse(head); 
    }
}