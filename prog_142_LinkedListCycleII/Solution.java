package prog_142_LinkedListCycleII;

public class Solution {

    /*
    Brute Force:

        We can maintain a HashSet and iterate through nodes, if my node exist that means cyle is detected and return
        the position of that node. Remember we will be storing the entire node in the hashset not just a value, bcoz at
        some places there might be duplicates.
        Time Complexity : O(N)
        Space Complexity : O(N)

    Fast and Slow pointer Approach:

    In this approach we will maintain 2 poniters starting from the head of LL. Slow pointer wil b incrementing by 1 and
    fast will be by 2.

    If both the pointers are meeting at one node that means cycle is detected.@interface

    Once we found the cycle, we want to find the node where cycle is meeting from tail to that node.
    For that, we wil reset the slow pointer to head, fast to the same node and we wil keep incrementing both the
    pointers by 1.
    When both the pointers are meeting at same location which means, from that node our cycle is generated.

    Time Complexity : O(N) + O(N) => 2O(N) => O(N)
    O(N) For finding cycle and O(N) for detecting the cycle node.
    Space Complexity : O(N)



     */

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;
        boolean detectCycle = false ;

        while(fast!=null && fast.next != null){ //If there's no cycle that means last node's next must be null or
            slow = slow.next ; // fast node will reach at null. Here we need to keep both condition in while.
            fast = fast.next.next;

            if(slow == fast){
                detectCycle = true;
                break ;
            }



        }

        if(detectCycle!= true)
            return null ;

        if(detectCycle == true){
            slow = head ;
            while(slow != fast){
                slow = slow.next ;
                fast = fast.next;
                if(slow == fast){
                    return slow ;
                }
            }
        }
        return slow ;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
