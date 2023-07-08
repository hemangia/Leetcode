package prog_206_ReverseLinkedList;

class Solution2 {
    /*
    Recursive Approach :
    In this solution we will b keep traversing the node and abandon the parent to recursive stack until it reaches to
    null.

    1 -----> 2 ----->3 -----> 4----->5 ----->null
    We will push in stack [1,   2,  3,  4]
    when we go to head = 5, our condition is not satisfying as head.next = null. 5 will not go to the stack.
    Then we will return head 5, it will store is reversed output ListNode.
    Stack.pop will happen and now my control is at head = 4

    when we do head.next.next = head we are removing the 5--->null link and make it to the 4
                               |--------->>>>>>-|
     1 -----> 2 ----->3 -----> 4----->5 ----->null
                               |<<<<<------------|
    Once we are done with the 4<<<---5 link, we will remove the 4---->5 and make it null.
    At the end, we will return the result reversed list

    Time Complexity : O(N)
    Space Complexity: O(N)

     */
    ListNode reversed;
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next== null)
            return head ;
        reversed=  reverseList(head.next); //Reversed is acting as a global variable, only the local variable
        System.out.println(reversed.val);  // 5 5 5 5
        //comes out of recursive stack

        //Stack.pop
        System.out.println(head.val);  // 4 3 2 1

        head.next.next = head ;
        head.next = null ;
        return reversed;

    }
}