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
    private ListNode reverseList(ListNode head){
        Stack<Integer> stack=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        ListNode newHead=new ListNode(-1);
        ListNode ptr=newHead;
        while(!stack.isEmpty()){
            ptr.next=new ListNode(stack.pop());
            ptr=ptr.next;
        }
        return newHead.next; 
    } 
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode list1=new ListNode(-1);
        ListNode ptr=list1;
        int count=1;
        ListNode temp=head;
        while(temp!=null){
            if(count>=left&&count<=right){
                ptr.next=new ListNode(temp.val);
                ptr=ptr.next;
            }
            count++;
            temp=temp.next;
        }
        ListNode sample=list1.next;
        ListNode reverse=reverseList(sample);
        ListNode list2=new ListNode(-1);
        ListNode ptr2=list2;
        temp=head;
        int fincount=1;
        while(temp!=null){
            if(fincount>=left&&fincount<=right){
                ptr2.next=new ListNode(reverse.val);
                reverse=reverse.next;
                ptr2=ptr2.next;
                temp=temp.next;
            }else{
                ptr2.next=new ListNode(temp.val);
                ptr2=ptr2.next;
                temp=temp.next;
            }
            fincount++;
        }
        return list2.next;
    }
}