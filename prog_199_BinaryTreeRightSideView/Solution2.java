package prog_199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /*
    In this approach, we wil be solving with DFS
                1
            2       3

        4       5       6

    7
    [1,    3,  6,  7]
    In this approach we will mantain a hashmap with values level and nodes
    {0 : 1
     1 : 2
     2 : 4
     3 : 7
    }
    As our recursion moves from left to right, we will keep overwriting the values of nodes with newest node, to get the rightmost node for each level
    As we know levels will be 0 to H then we will use Arrays or ArrayList and use index as a level.
Time Complexity : O(N)
Space Complexity : O(H) or O(N)

     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result ;
    }
    public void helper(TreeNode root, int level, List result){
        if(root == null ) return ;
        if(level == result.size()){
            result.add(root.val);
        }
        else{
            result.set(level, root.val);
        }
        helper(root.left, level + 1 , result);
        helper(root.right, level + 1 , result);

    }
}