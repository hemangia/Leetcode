package prog_993_CousinsinBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    /*
    BFS Approach 2:
    In this approach, we dont need to maintain the parent queue.
    We can do parent checks, if our curr node's left and right child are not equal to x and y
    If they are, then return false. (Line 50 - 57)
    At the end we wil jst check the result found flags.
    Time Complexity: O(N)
    Space Complexity: O(N)
     */
    public boolean isCousins(TreeNode root, int x, int y) {


        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            boolean xFound = false;
            boolean yFound = false;
            TreeNode xParent = null ;
            TreeNode yParent = null ;

            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();

                if(curr.val == x){
                    xFound = true;
                }
                if(curr.val == y){
                    yFound = true;
                }
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val == x && curr.right.val == y){
                        return false ;
                    }
                    if(curr.left.val == y && curr.right.val == x){
                        return false ;
                    }
                }
                if(curr.left!=null){
                    q.add(curr.left);

                }
                if(curr.right!=null){
                    q.add(curr.right);

                }
            }
            if(xFound == true && yFound == true){
                return true ;
            }
        }
        return false;
    }
}
