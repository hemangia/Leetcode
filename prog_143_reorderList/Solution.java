package prog_143_reorderList;

public class Solution {
    /*
    In this problem, we have given a list
    1---->2----->3----->4------>5----->6----->7----->null
    We have to form
    1---->7----->2----->6------>3----->5----->4----->null

    1)  In this approach we have to find middle of the list using fast and slow pointer.
    2)  Once middle is found from next node of middle, we have to reverse the list.
    3)  Once we found the reverse, we wil merge both the list.

    Time Complexity: O(N) + O(N) + O(N) => O(N)
    Space Complexity: O(1)



     */
    public void reorderList(ListNode head) {
        if(head==null || head.next == null )
            return ;

        //Step 1: Find the middle
        ListNode slow = head;
        ListNode fast = head ;
        while(fast.next !=null && fast.next.next !=null){
            fast = fast.next.next ;
            slow = slow.next ;
        }

        //Step 2 : Reverse the list
        ListNode newMid = reverse(slow.next);
        slow.next = null ;
        slow = head ;

        //Step 3: merge the list

        while(newMid!=null){
            ListNode temp = slow.next ;
            slow.next = newMid ;
            newMid = newMid.next ;
            slow.next.next = temp ;
            slow = temp ;

        }

    }
    public ListNode reverse(ListNode head){

        ListNode prev = null ;
        ListNode curr = head ;
        ListNode future = head.next ;
        while(future!=null){
            curr.next = prev ;
            prev = curr;
            curr = future ;
            future = future.next ;
        }
        curr.next = prev ;
        return curr ;
    }
}

 class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }