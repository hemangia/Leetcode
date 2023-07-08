package prog_113_pathSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
    In this problem, we have given the target sum and we have to return list of all the paths whose total till the leaf
    is equal to target.

    1)  In our helper function, we can maintaining list of nodes, curr sum, target
        Whenever we are traversing we are adding the node to that list and adding the value of root to the current sum.
    2)  If my root is leaf node and if current sum = target, then add that list to result.

    3)  Data structure inside a data structure is always pointer. Suppose in our recursion stack we are adding root,
        its sum and list of root traversed, the sum is passed by a value, but the list is passed by reference, coz list
        is another data structure.
            4
        9       8
    5
        Suppose at root 4 our parameters are (root = 4, currSum= 4, list[4] at address 241)
        Whenever we are calling recursion function parent 4 goes to recursion stack and list[4] address will be passed.
        At the end list will be [4 9 5]
        When we are going to right subtree at node 8 the same subtree will be passed and our result will be [4 9 5 8].

        In order to solve this issue, Whenever we are calling recursion function we have to create to list and pass
        previous list inside newly created list.
        helper(root.left, currSum, new ArrayList<Integer>(currentList), targetSum);
        helper(root.right, currSum, new ArrayList<Integer>(currentList), targetSum);
        We can do this way or below way(Deep copy)

        currSum = currSum + root.val ;
        List<Integer> newList = new ArrayList<>(currentList);
        newList.add(root.val);
        helper(root.left, currSum, newList, targetSum);

        Time Complexity : O(N^2)
        O(N) for traversing list and every node, we are copying elements from 1 list to another so O(N) for copying.
        At every path we will be copying H nodes in the list and not all nodes.
        O(N * H)
        Space Complexity:  O(N^2) => O(N * H)
        coz at every node we are creating list of H elements
        This solution is not efficient.


     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, 0, new ArrayList<>(), targetSum);
        return result ;

    }
    public void helper(TreeNode root, int currSum, List<Integer> currentList, int targetSum){
        if(root == null)
            return ;

        currSum = currSum + root.val ;
        List<Integer> newList = new ArrayList<>(currentList);
        newList.add(root.val);

        if(root.left ==null && root.right == null){
            if(currSum == targetSum){
                result.add(newList);
            }
        }
        helper(root.left, currSum, newList, targetSum);
        helper(root.right, currSum, newList, targetSum);
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