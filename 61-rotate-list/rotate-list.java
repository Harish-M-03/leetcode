class Solution {
    private static ListNode Removetail(ListNode head){
        if(head==null||head.next==null){
            return head; 
        }
        ListNode prev=null;
        ListNode curr=head;
        while(curr.next!=null){
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;

        return curr;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
            
        }
        k=k%count;
        if(k==0){
            return head;
        }
        while(k-- >0){
            ListNode tail=Removetail(head);
            tail.next=head;
            head=tail;
        }
        return head;
    }
} 