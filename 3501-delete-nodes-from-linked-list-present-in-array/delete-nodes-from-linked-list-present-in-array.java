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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> sample = new HashSet<>();
        for (int num : nums) {
            sample.add(num);
        }
        ListNode temp=head;
        ListNode newHead=new ListNode(-1);
        ListNode ptr=newHead;
        while(temp!=null){
            if(!sample.contains(temp.val)){
                ptr.next=new ListNode(temp.val);
                ptr=ptr.next;
            }
            temp=temp.next;
        }
        return newHead.next;
    }
}