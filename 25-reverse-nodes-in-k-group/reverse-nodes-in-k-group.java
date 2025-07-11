import java.util.Stack;

class Solution {

    

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        ListNode groupPrev = dummy;

        ListNode current = head;

        while (current != null) {
            Stack<ListNode> stack = new Stack<>();
            ListNode temp = current;

            int count = 0;
            while (count < k && temp != null) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }

            if (count < k) {
                groupPrev.next = current; // less than k, attach rest as-is
                break;
            }

            // Reverse group
            while (!stack.isEmpty()) {
                groupPrev.next = new ListNode(stack.pop().val);
                groupPrev = groupPrev.next;
            }

            current = temp;
        }

        return dummy.next;
    }
}
