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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead=new ListNode(-1);
        ListNode ptr=newHead;
        ListNode temp1=l1;
        ListNode temp2=l2;
        int carry=0;
        while(temp1!=null||temp2!=null||carry!=0){
            int v1=temp1!=null?temp1.val:0;
            int v2=temp2!=null?temp2.val:0;
            int sum=v1+v2+carry;
            ptr.next=new ListNode(sum%10);
            ptr=ptr.next;
            carry=sum/10;
            temp1=temp1!=null?temp1.next:null;
            temp2=temp2!=null?temp2.next:null;
        }
        return newHead.next;
    }
}