package prog_206_ReverseLinkedList;

class Solution {
    /*
    Iterative Solution:
    We will use 3 pointers

    Time Complexity : O(N)
    space complexity : O(1)


     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head ;
        ListNode prev = null ;
        ListNode curr = head ;
        ListNode future = head.next;

        while(future!=null){

            curr.next = prev ;
            prev = curr;
            curr = future ;
            future = future.next ;

        }
        curr.next = prev ;
        return curr;
    }
}

 class ListNode {
     int val;
    ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
