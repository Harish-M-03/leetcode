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
        Stack<Integer> stack=new Stack<>();
        int cnt=0;
        ListNode temp=head;
        ListNode newHead=new ListNode(-1);
        ListNode ptr=newHead;
        while(temp!=null){
            cnt++;
            stack.push(temp.val);
            if(cnt%k==0){
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