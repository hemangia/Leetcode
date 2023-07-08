package prog_98_validateBinarySearchTree;

public class Solution {
    /*
In this solution, we will be doing In order traversal and we wil be having 1 poniter lagging to the root.
We will maintain two pointers, curr pointer and previous pointer
1) We will check if my curr pointer is greater than previous pointer where curr pointer is always root.
2) If my curr pointer is greater, then move prev to curr and  go to the next root
3) If not then, its not binary search tree.


*/
    TreeNode prev =null ;
    //Remember, we should maintain these variables globally and not locaaly for 1-1 mapping.

    TreeNode curr =null ;
    boolean result = true ;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return result ;
    }

    public void inorder(TreeNode root){ // We can have return type as a void or boolean
        // It doesnt matter.
        if(root == null){
            return ;
        }
        if(result != false){ // Whenever any breach happen, we dont want our program to be
            //executed for the remaining nodes, that's why we can put this condition here before //
            //calling every recursive function, we check if my result flag is true or not
            // If false, then no need to call recursion for further nodes.
            inorder(root.left);
        }

        //Pop

        // System.out.print("Up");
        // System.out.println(root.val);
        curr = root ;
        if(prev!=null && prev.val >= curr.val ){
            result = false ;
            return ;
        }
        prev = curr ;
        if(result != false){// Whenever any breach happen, we dont want our program to be
            //executed for the remaining nodes, that's why we can put this condition here before //
            //calling every recursive function, we check if my result flag is true or not
            // If false, then no need to call recursion for further nodes.
            inorder(root.right);
        }
        //Pop


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