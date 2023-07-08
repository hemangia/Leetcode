package prog_98_validateBinarySearchTree;
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution2 {
    /*
This is boolean return based solution where, we check the return value of left subtree and right subtree.
1)  We are maintaining 2 pointers, curr and prev. My current pointer is at current node which is root
    and prev pointer is 1 node lagging.
2)  I will check if my prev > curr at any point breach happen then return false otherwise prev = curr
    and continue our recursion.
3)  This is an exhaustive recursion which means even if breach happen, it will execute recursion for
    all the nodes.
    We need conditional recursion, that's why we have added the if conditions at line 41, 55


     */
    TreeNode curr ;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    public boolean inOrder(TreeNode root){
        if(root == null )
            return true ;

        boolean left = inOrder(root.left);
        //Stack.pop()
        if(left == false){
            return false ;
        }

        System.out.println(root.val+ " Left is : "+ left );

        curr = root ;
        if( prev !=null && prev.val >= curr.val){
            return false ;
        }
        prev = curr ;

        boolean right = inOrder(root.right);
        //Stack.pop()
        if(right == false){
            return false ;
        }
        System.out.println(root.val+ " Right is : "+ right );

        return left && right ;

    }
}