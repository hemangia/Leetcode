package prog_106_ConstructTreefromPostorderandInorder;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

 class Solution {
    /*
   Same as preOrder
   Remember for post order we will be starting last index of postorder array and we wil keep decreasing
   In pre order we do Root- Left -Right

       TreeNode root = new TreeNode(rootVal);
       root.left = helper(preorder, inorder, start, rootIndex -1);
       root. right= helper(preorder, inorder, rootIndex + 1, end);
       here we get the Root 1st then left tree and right tree in forward direction

   In post order, we do Left -- Right -- Root
   Once we get the root, we will come backward and we will do right 1st and left 2nd
   TreeNode root = new TreeNode(rootVal);

   root.right= helper(preorder, inorder, rootIndex + 1, end);
   root.left = helper(preorder, inorder, start, rootIndex -1);

   Time Complexity : O(N)  coz we are traversing all the nodes only once.
   Space Complexity : O(N) coz we are making an hashmap
   We can remove the inorder from recursive call as we are getting inorder values directly from map.
    */
    int preIndex ;
    HashMap<Integer, Integer> map ;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.preIndex= postorder.length -1  ;
        this.map = new HashMap<>();
        for(int i=0; i< inorder.length ;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] postorder, int start, int end){
        //Base: When start pointer crosses right, return null
        if(start>end)
            return null ;

        //Logic
        int rootVal = postorder[preIndex];
        preIndex -- ;// We started from last index and for next iteration we have decremented it

        int rootIndex = map.get(rootVal); // get the index of inorder from map.
        TreeNode root = new TreeNode(rootVal);

        root.right= helper(postorder, rootIndex + 1, end); // Right should call 1st
        root.left = helper(postorder, start, rootIndex -1); // Then left
        return root ;

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


