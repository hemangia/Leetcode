package prog_19_RemoveNthNodeFromEndofList;

public class Solution {
    /*
    In this problem, we have to remove the nth node from the end.

    In this solution we are maintaining 2 pointers slow and fast.
    Basically we are maintaining window between slow and fast of length n and shifting window till fast reaches null.
    When fast reaches null it means our slow pointer is already at node before the item which needs to be removed.

    1	---->	2---->3---->4---->5---->6---->7---->8---->9---->null
    |							|
Slow					Fast

1	---->	2---->3---->4---->5---->6---->7---->8---->9---->null
                |						|
            Slow					Fast


     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow =dummy;
        ListNode fast = dummy ;
        int count =0 ;
        while(count<=n){
            fast =fast.next ;
            count++ ;
        }
        while(fast != null){
            slow =slow.next ;
            fast=fast.next;
        }
        ListNode temp = slow.next ;
        slow.next = slow.next.next;
        temp.next = null ;
        return dummy.next ;
    }
}

  class ListNode {
    int val;
     ListNode next;
   ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}