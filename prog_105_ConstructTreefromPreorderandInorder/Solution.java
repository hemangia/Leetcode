package prog_105_ConstructTreefromPreorderandInorder;

import java.util.Arrays;

class Solution {
    /*
    In this problem, we have given pre and in order arrays and we have to build a tree.
                    in-left                            in-right
                <------------------------>     R    <----------------->
    Inorder     [11,    10,     12,     9,     3,   15,     20,     7]

    preOrder    [3,     9,      10,     11,    12,  20,     15,     7]
                        <------------------------>  <----------------->
                R       pre-left                      pre-right


    As we know 0th index of preOrder is always Root, we will check that root inOrder and figure out left and right
    section. and from pre-left and in-left we wil keep build tree and pre-right and in-right we will keep building
    tree.

    Time Complexity : 3 * O(N) => O(N) => O(N) for searching the root and O(N)+ O(N) for making deep copies.
    For each node, we are doing a recursive call, O(N)
    Total Complexity : O(N^2)

        Space Complexity : O(N^2)  => At each and every node we are creating new arrays.
    This is not an efficient solution.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootVal = preorder[0];
        int inRootIndex= -1 ;
        for(int i=0; i<= inorder.length -1 ;i++) { // O(N)
            if(inorder[i] == rootVal){
                inRootIndex = i ;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder,0, inRootIndex);
        int[] inRight = Arrays.copyOfRange(inorder,inRootIndex+1, inorder.length);
        // O(N) combined 2 arrays

        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder,preLeft.length+1, preorder.length);
        // O(N) combined 2 arrays

        root.left =  buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;

    }
}
  class TreeNode {
     int val;
    TreeNode left;
    TreeNode right;
     TreeNode() {}
    TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
       this.left = left;
         this.right = right;
    }
 }
