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
    private ListNode reverse(ListNode head){
        ListNode current=head;
        ListNode prev=null;
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    } 
    public ListNode removeNthFromEnd(ListNode head, int n) {

    if(head == null) return null;

    if(head.next == null && n == 1){
        return null;
    }

    ListNode temp = reverse(head);

    if(n == 1){
        temp = temp.next;
    } else {
        int cnt = 0;
        ListNode prev = null;
        ListNode current = temp;

        while(current != null){
            cnt++;

            if(cnt == n){
                prev.next = current.next;
                break;
            }

            prev = current;
            current = current.next;
        }
    }

    return reverse(temp);
}
}