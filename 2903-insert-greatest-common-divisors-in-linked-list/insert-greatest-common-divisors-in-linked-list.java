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
    private int GCD(int a,int b){
        if(b==0){
            return a;
        }
        return GCD(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode current=head;
        ArrayList<Integer> arr=new ArrayList<>();
        while(current.next!=null){
            prev=current;
            current=current.next;
            int num=GCD(prev.val,current.val);
            arr.add(num);
        }
        int k=0;
        ListNode newHead=new ListNode(-1);
        ListNode ptr=newHead;
        current=head;
        while(k<arr.size()){
            ptr.next=new ListNode(current.val);
            ptr=ptr.next;
            current=current.next;
            ptr.next=new ListNode(arr.get(k++));
            ptr=ptr.next;
        }
        ptr.next=current;
        return newHead.next;
    }
}