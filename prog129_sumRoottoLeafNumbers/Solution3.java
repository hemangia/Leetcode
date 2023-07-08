package prog129_sumRoottoLeafNumbers;

class Solution3 {
    /*

    In this problem, we have to count the total of each path and return the total's of path.
    We have 2 variable totalSum is global and currNum is local
             4
        9       0
    5       1

Int Based Recursion:

Remember We will not be able to do the things by making global variable to local ever.

Here, we will be doing bottom up recursion on left we wil getting sum, on right we wil be getting sume and we wil be giving it to the parent.

     */

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);

    }
    public int helper(TreeNode root, int currNum){
        //base
        if(root==null)
            return 0;

        currNum = currNum * 10 + root.val ;

        if(root.left == null && root.right==null){

            return currNum ;
        }


        int left = helper(root.left, currNum);
        //pop
        int right= helper(root.right, currNum);
        //pop

        return left + right ;
    }
}
