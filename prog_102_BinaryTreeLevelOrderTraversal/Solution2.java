package prog_102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /*
    DFS solution with Recursion :
    In this solution we are maintaining the level variable along with the root value.


     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        dfs(root, 0);
        return result ;

    }
    public void dfs(TreeNode root, int level){
        if(root==null) return ;
        int size = result.size() ;
        if(level == size){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        //Stack.pop()
        dfs(root.right, level+1);
        //Stack.pop()
    }
}
