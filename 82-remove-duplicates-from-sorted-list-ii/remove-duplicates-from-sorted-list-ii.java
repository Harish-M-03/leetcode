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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        // LinkedHashMap preserves insertion order of the values as they appear in the list
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }

        // Build new list keeping only values that occurred exactly once, in original order
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                ptr.next = new ListNode(e.getKey());
                ptr = ptr.next;
            }
        }
        return dummy.next;
    }
}
