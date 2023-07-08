package prog_199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    In this solution, we have to show right side of the tree
            1
        2       3

    4       5       6

 7
 [1,    3,  6,  7]
 We are doing bfs and we wil be adding last element of every level in the result.
 For left side, we jst have to change the condition
              if(i == 0){
                result.add(curr.val);
                }

    */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null ) return result ;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size() ;

            for(int i=0;i < size ; i++){
                TreeNode curr = q.poll();
                if(i == size - 1){
                    result.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return result ;

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