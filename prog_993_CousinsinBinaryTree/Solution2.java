package prog_993_CousinsinBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    /*
    BFS Approach 1:
    In this we wil maintain 2 queues, one for child and one for parent.
    Whenever we are pushing or removing from the queue, we wil add/ remove its parent.
    We will check level wise whether both the nodes are found or not. If yes then we wil check their parents.
    We will return result accordingly.
    Time Complexity: O(N)
    Space Complexity: O(N)
     */
    public boolean isCousins(TreeNode root, int x, int y) {


        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        q.add(root);
        pq.add(null);
        while(!q.isEmpty()){
            int size = q.size();

            boolean xFound = false;
            boolean yFound = false;
            TreeNode xParent = null ;
            TreeNode yParent = null ;

            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                TreeNode currParent = pq.poll();
                if(curr.val == x){
                    xFound = true;
                    xParent = currParent;
                }
                if(curr.val == y){
                    yFound = true;
                    yParent = currParent;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                    pq.add(curr);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    pq.add(curr);
                }
            }
            if(xFound == true && yFound == true){
                if(xParent != yParent){
                    return true ;
                }
            }
        }
        return false;
    }
}
