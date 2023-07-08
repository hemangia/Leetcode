package prog_993_CousinsinBinaryTree;

public class Solution {
    /*
    In this problem we have given 2 nodes and we have to find if both the nodes are cousins or not.
    The cousins nodes are the 2 nodes which are on same level and which has different parent.
    1)  In dfs approach, we will be going through each and every node, and we are checking if my node is matching with
        given nodes. If they are we are saving its level and parent value.
    2)  After getting both the nodes level and parent, we will be checking whether its on same level and whether their p
    arents are different

    Time Complexity : O(N)
    Space Complexity: O(N)
     */
    int xLevel = -1 ;
    int yLevel = -1 ;
    TreeNode xParent , yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,0,null,x,y);
        if(xLevel==yLevel){
            if(xParent!=yParent){
                return true ;
            }
        }
        return false ;
    }
    public void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        if(root == null) return ;
        if(root.val == x){
            xLevel = level ;
            xParent = parent;
        }
        if(root.val == y){
            yLevel = level ;
            yParent = parent;
        }
        dfs(root.left, level + 1, root, x, y);
        dfs(root.right, level + 1, root, x, y);

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
