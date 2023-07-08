package prog_173_BinarySearchTreeIterator;

import java.util.Stack;

public class Solution {
    /*
    In this problem, we have to build an iterator for BST. The basic properties are hasNext and Next.
    Brute Force :
    1) We can create a list of nodes, and add all the nodes in inorder traversal.
    2) We wil index start from the begining of the list, whenever we can the next we wil return the current index value
    and increment index to the next node.
    3) whenever we call hasNext, we will see if the index is withing the range of length of list
    4) This approach is not handling the dynamic nature of iterator.

    Controlled Recursion:
    1) In this approach, we will control our recursion and call only when its needed.
    2) For e.g : We will be traversing the left of tree and we will go to the right part only when root is popped and
        next function gets called.
        i)  We will maintain a stack which has nodes, whenever hasNext called, we will see if my stack is empty or not.
        ii) whenever next() is called, we will pop the top of stack which means root and return that value and then we
            wil call the right subtree of root.
    3) Time Complexity: O(1) for both the opertaions





     */
    Stack<TreeNode> st ;

    public Solution(TreeNode root) {
        this.st = new Stack<>();
        helper(root);
    }
    public void helper(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left ;
        }
    }
    public int next() {
        TreeNode result = st.pop();
        helper(result.right);
        return result.val ;
    }

    public boolean hasNext() {
        boolean result = st.isEmpty();
        return !result ; // here we have to return opposite
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