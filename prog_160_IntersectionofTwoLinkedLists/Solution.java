package prog_160_IntersectionofTwoLinkedLists;

public  class Solution {
    /*
    In this problem, we have given 2 linked list and we have to find the intersection node of both the lists.

    Approach 1 :
    We can maintain a hashset of pointers where we store all the values from 1 hashset and then we can iterate through
    2nd hashset checking if node is present or not, if yes, that's the common intersection node.
    Time complexity : O(M+N)
    Space complexity: Max between O(M) or O(N)


    Approach 2:
    Here, first we find the length of both the list. Whichever size is greter, we will traverse that list till it
    reaches same length as smaller list.
    When both the lists are meeting at a node, that's the intersection node.
    Time complexity : O(M+N)



     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA=0, sizeB = 0 ;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA !=null){
            sizeA ++ ;
            tempA=tempA.next;

        }
        System.out.println(sizeA);

        while(tempB!=null){
            sizeB++;
            tempB=tempB.next;
        }
        System.out.println(sizeB);

        if(sizeA>sizeB){
            int diff = sizeA - sizeB ;
            int count =1 ;
            while(count<=diff){
                headA = headA.next ;
                count ++ ;
            }
        }
        if(sizeA < sizeB){
            int diff = sizeB - sizeA ;
            int count =1;
            while(count <= diff){
                headB = headB.next ;
                count ++ ;
            }
        }
        while(headA != headB ){
            headA = headA.next;
            headB = headB.next ;
        }
        return headA ;

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
