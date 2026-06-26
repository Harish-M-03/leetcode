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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead=new ListNode(-1);
        ListNode ptr=newHead;
        Stack<Integer> stack=new Stack<>();
        int cnt=0;
        ListNode temp=head;
        while(temp!=null){
            cnt++;
            if(cnt>=left&&cnt<=right){
                stack.push(temp.val);
            }
            temp=temp.next;
        }
        temp=head;
        cnt=0;
        while(temp!=null){
            cnt++;
            if(cnt>=left&&cnt<=right){
                ptr.next=new ListNode(stack.pop());
                ptr=ptr.next;
            }else{
                ptr.next=new ListNode(temp.val);
                ptr=ptr.next;
            }
            temp=temp.next;
        }
        return newHead.next;
    }
}