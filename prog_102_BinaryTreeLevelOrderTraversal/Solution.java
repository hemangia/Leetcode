package prog_102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    BFS Iterative approach :

    1) Here we are doing nothing but adding an children's of root in the queue whenever we are removing parent from
    queue and adding itr into list
    Time Complexity : O(N)
    Space Complexity: O(N)




     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result ;
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size() ;
            List<Integer> li = new ArrayList<>();
            for(int i =0; i< size ; i++){
                TreeNode currRoot = que.poll();

                li.add(currRoot.val);

                if(currRoot.left !=null) {
                    que.add(currRoot.left);
                }

                if(currRoot.right!=null){
                    que.add(currRoot.right);
                }
            }
            result.add(li);
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
