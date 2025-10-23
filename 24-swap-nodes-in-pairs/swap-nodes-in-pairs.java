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
        // handle empty or single-node lists
        if (head == null || head.next == null) return head;

        // Separate odd and even indexed nodes
        ListNode oddhead = head;
        ListNode oddptr = oddhead;
        ListNode evenhead = head.next;
        ListNode evenptr = evenhead;

        // Split original list into two lists: odd-index nodes and even-index nodes
        while (evenptr != null && evenptr.next != null) {
            oddptr.next = evenptr.next;
            oddptr = oddptr.next;

            evenptr.next = oddptr.next;
            evenptr = evenptr.next;
        }

        // IMPORTANT: terminate both lists so there are no stray links/cycles
        if (oddptr != null) oddptr.next = null;
        if (evenptr != null) evenptr.next = null;

        // Merge alternately: even node first, then odd node (to achieve swapping)
        ListNode result = new ListNode(-1);
        ListNode resptr = result;

        oddptr = oddhead;
        evenptr = evenhead;

        while (oddptr != null && evenptr != null) {
            // attach even (the new first of the pair)
            resptr.next = evenptr;
            resptr = resptr.next;
            evenptr = evenptr.next;

            // attach odd (the new second of the pair)
            resptr.next = oddptr;
            resptr = resptr.next;
            oddptr = oddptr.next;
        }

        // attach any leftover nodes (only one of these can be non-null)
        if (oddptr != null) resptr.next = oddptr;
        else if (evenptr != null) resptr.next = evenptr;
        else resptr.next = null;

        return result.next;
    }
}
