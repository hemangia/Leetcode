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
class Solution3 {
    /*
    In this solution, we will be maintaining two limit, low and high and my root value should lies between the range.

    1)  Whenever we are going to the left our high value changes to root, and lower limit remain the same
    2)  Whenever we go to the right, our high value changes and lower limit changes to root
    3)  If at any point any breach happen, then we will be returning false
    4)  We have used condition based recursion.


     */
    boolean flag = true ;
    public boolean isValidBST(TreeNode root) {
        inOrder(root, null, null);
        return flag;
    }
    public void inOrder(TreeNode root, Integer low, Integer high){
        if(root == null)
            return ;
        if((low !=null && root.val <= low) || (high !=null && root.val >= high) ){
            flag = false ;
        }
        System.out.println("Root : "+ root.val +" low = "+low+ " High = " +high);
        if(flag== true){
            inOrder(root.left, low, root.val);
        }

        if(flag== true){
            inOrder(root.right,root.val, high);
        }



    }
}

/**
 class Solution {
 /*


 In this solution, we will be maintaining two limit, low and high and my root value should lies between the range.

 1)  Whenever we are going to the left our high value changes to root, and lower limit remain the same
 2)  Whenever we go to the right, our high value changes and lower limit changes to root
 3)  If at any point any breach happen, then we will be returning false
 4)  We have used condition based recursion.


 */
 /*
boolean flag = true ;
    public boolean isValidBST(TreeNode root) {
        inOrder(root, null, null);
        return flag;
    }
    public void inOrder(TreeNode root, Integer low, Integer high){
        if(root == null)
            return ;
        if((low !=null && root.val <= low) || (high !=null && root.val >= high) ){
            flag = false ;
        }
        System.out.println("Root : "+ root.val +" low = "+low+ " High = " +high);
        if(flag== true){
            inOrder(root.left, low, root.val);
        }

        if(flag== true){
            inOrder(root.right,root.val, high);
        }



    }
}
 */

