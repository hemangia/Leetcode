package prog_105_ConstructTreefromPreorderandInorder;

import java.util.HashMap;

public class Solution2 {
    /*
    In our previous Solution we were splitting and creating a new array at every node which is not efficient. To
    resolve this, we will use a 2 pointers and pass the entire array in the recursion.
    1) We will maintain a hashmap of inorder array which will maintain nodes and its indexes for making search O(1)
    2) I dont need to make a split on preorder array.
    preOrder    [3,     9,      10,     11,    12,  20,     15,     7]
                R
    We dont know the span of left subtree of Root 3 but surely know that next root will be 9. Sure.
        So.           3
                    9
                If I do next recursive call, then       3
                                                    9
                                                10
                 If I do next recursive call, then       3
                                                    9
                                                10
                                            11
                Now with the inorder traversal pointers, I will manage the recursion. The recursion will be taken care
                of inorder traversal.
                Preorder will keep giving me the next root. On preOrder array we will maintain 1 single poniter which
                will just keep iterating.
                1)In inorder array my start will be at 0 and end at last index.
                 0      1       2       3      4    5       6       7
    Inorder     [11,    10,     12,     9,     3,   15,     20,     7]
                 S                                                   E
                2) Now from preOrder array,  Root = 3
                3) find the index of root=3 on Inorder array
                    Index = 4
                4) Now when I am doing the left recursive call, abandon the parent inside the stack.
                    in[3,0,7]  parent=3 start 0 and end = 7
                5) Now we will call left. When we are calling left, keep the start same and end changes to root index -1
                    Start = same as previous
                    end   = Root index - 1
                 0      1       2       3      4    5       6       7
    Inorder     [11,    10,     12,     9,     3,   15,     20,     7]
                 LS                     LE

                 6)  Now we will call right. When we are calling right, keep the start index +1  and end remains same.
                    Start = Root index + 1
                    end   =  same
                 0      1       2       3      4    5       6       7
    Inorder     [11,    10,     12,     9,     3,   15,     20,     7]
                                                     RS             RE

                 7) Now once this has given us 1st root, increase pointer of preorder, which will give next Root.
                 Root = 9
                 Then we will find 9, in hashmap to get the index in Inorder
                 Index = 3
                 Further left of left subtree
                 LS = same
                 LE = Index - 1

                 8) Now we will abandon the child into stack, and root will be 10
                    Stack = [
                                [in(9,0,3)],
                                [in(3,0,7)]
                             ]
                    Root = 10
                    Index = 1

                 9) we will call left
                  0      1       2       3      4    5       6       7
    Inorder     [11,    10,     12,     9,     3,   15,     20,     7]
                 LS      R

                 Now push the parent to stack
                  Stack = [
                                [in(10,0,2,1)]
                                [in(9,0,3,3)],
                                [in(3,0,7,4)]
                             ]

                    Root = 11
                    index = 0
                    Span of left subtree will be from 0 to 0
                    LS= 0
                    LE = -1
                    Now LS has crossed LE, means so element in left, so we will be returning null on 11 left.

                 Now push the parent to stack
                  Stack = [
                                [in(11,0,0,0)]
                                [in(10,0,2,1)],
                                [in(9,0,3,3)],
                                [in(3,0,7,4)]
                             ]
                    Root = null
                    our tree will be
                                            3
                                        9
                                    10
                                11
                            null

                    Now my left is null, it will break the loop and parent will come out of stack
                    Root = 11
                    We will be doing right recursive of 11
                    RS= 1
                    RE = 0
                    Again its crossed each other, return null
                    our tree will be
                                            3
                                        9
                                    10
                                11
                            null    null
                        Now 11 comes out of stack
                        Root = 10

                    10 ) Now we will do right recursive call on 10
                        Root = 10
                        Index = 1
                        RS = 2 ,  RE = 2
                        We will do right recursive call on this
                        abandon the parent inside the stack
                         Stack = [
                                [in(10,2,2,1)],
                                [in(9,0,3,3)],
                                [in(3,0,7,4)]
                             ]
                        We will move to next preOrder root which is 12
                        Root = 12
                        RS  =   3
                        RE  =   2

                          our tree will be
                                            3
                                        9
                                    10
                                11      12
                                   null     null


                    Now we are done with both the recursion call of 10, our control go back to 9
                    and parent 9 comes out of stack
                    Root = 9

                     Stack = [

                                [in(9,0,3,3)],
                                [in(3,0,7,4)]
                             ]

                    Now 3 comes out and we will do right recursive call on 3
                    Root = 3
                    Index = 4
                    RS = 5
                    RE = 7

    Time Complexity : O(N)  coz we are traversing all the nodes only once.
    Space Complexity : O(N) coz we are making an hashmap

    We can remove the inorder from recursive call as we are getting inorder values directly from map.

     */
    int preIndex ;
    HashMap<Integer, Integer> map ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preIndex= 0 ;
        this.map = new HashMap<>();
        for(int i=0; i< inorder.length ;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);


    }
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //Base: When start pointer crosses right, return null
        if(start>end)
            return null ;

        //Logic
        int rootVal = preorder[preIndex];
        preIndex ++ ;// We started from 0 and for next iteration we have incremented it

        int rootIndex = map.get(rootVal); // get the index of inorder from map.
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, inorder, start, rootIndex -1);
        root. right= helper(preorder, inorder, rootIndex + 1, end);
        return root ;

    }
}
