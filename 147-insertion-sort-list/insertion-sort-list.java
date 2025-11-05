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
    private ArrayList<Integer> Sorting(ArrayList<Integer> arr,int start,int end){
        for(int i=1;i<end;i++){
            int j=i-1;
            int key=arr.get(i);
            while(j>=0&&arr.get(j)>=key){
                arr.set(j+1,arr.get(j));
                j=j-1;
            }
            arr.set(j+1,key);
        }
        return arr;
    }
    public ListNode insertionSortList(ListNode head) {
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        Sorting(arr,0,arr.size());
        ListNode newHead=new ListNode(-1);
        ListNode ptr=newHead;
        for(int i=0;i<arr.size();i++){
            ptr.next=new ListNode(arr.get(i));
            ptr=ptr.next;
        }
        return newHead.next; 
    }
}