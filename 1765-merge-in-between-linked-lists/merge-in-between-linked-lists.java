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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count=0;
        ListNode temp1=list1;
        ListNode temp2=list2;
        ListNode newHead=new ListNode(-1);
        ListNode ptr=newHead;
        while(temp1!=null){
            if(count<a){
                ptr.next=new ListNode(temp1.val);
                ptr=ptr.next;
            }
            if(a==count){
                while(temp2!=null){
                    ptr.next=new ListNode(temp2.val);
                    ptr=ptr.next;
                    temp2=temp2.next;
                }
            }
            if(count>b){
                ptr.next=new ListNode(temp1.val);
                ptr=ptr.next;
            }
            count++;
            temp1=temp1.next;
        }
        return newHead.next;
    }
}