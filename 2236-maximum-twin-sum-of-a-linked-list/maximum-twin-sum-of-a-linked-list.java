class Solution {
    private ListNode reverse(ListNode node){
        ListNode current=node;
        ListNode prev=null;
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        slow=reverse(slow);
        ListNode temp=head;
        int maxi=Integer.MIN_VALUE;
        while(temp!=null&&slow!=null){
            int sum=temp.val+slow.val;
            maxi=Math.max(maxi,sum);
            temp=temp.next;
            slow=slow.next;
        }
        return maxi;
    }
}