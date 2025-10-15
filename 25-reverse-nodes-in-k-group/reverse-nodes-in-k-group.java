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
    private ListNode reverse(ArrayList<Integer> arr){
        Stack<Integer> stack=new Stack<>();
        for(int num:arr){
            stack.push(num);
        }
        ListNode rev=new ListNode(-1);
        ListNode ptr=rev;
        while(!stack.isEmpty()){
            ptr.next=new ListNode(stack.pop());
            ptr=ptr.next;
        }
        return rev.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode result=new ListNode(-1);
        ListNode ptr=result;
        ListNode temp=head;
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
            if(arr.size()==k){
                ListNode r=reverse(arr);
                ListNode t=r;
                while(t!=null){
                    ptr.next=new ListNode(t.val);
                    ptr=ptr.next;
                    t=t.next;
                }
                arr.clear();
            }
        }
        for(int num:arr){
            ptr.next=new ListNode(num);
            ptr=ptr.next;
        }
        return result.next;
    }
}