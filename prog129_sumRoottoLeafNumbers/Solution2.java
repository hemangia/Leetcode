package prog129_sumRoottoLeafNumbers;


class Solution2 {
    /*
    In this problem, we have to count the total of each path and return the total's of path.
    We have 2 variable totalSum is global and currNum is local
             4
        9       0
    5       1
In this example, we need at every traversal we need sum like 495, 491,40
1)  At every traversal, we wil check if it is leaf or not. If yes then we wil add it to the total sum.
    Before checking our leaf, we need to calculate the traversal sum with its root value and maintain its own copy.
i)  We will start wilth 4, curr initially will be 0 then we calculate curr = 4 and then called its left
ii) When we are going to 9, we will send curr = 4 then we calculate curr=prev curr * 10 + root
    curr = 4 * 10 + 9 => 49
iii) When we reach 5, we wil send our prev curr = 49 and calculate new curr = prev curr * 10 + root
     curr = 49* 10 + 5 = 495
2)   When the node is leaf then we will add into total sum and return to the place its called and its parent pops out
     and call its right recursion.
3)   We can add our our condition in any order, pre, in, post.
        helper(root.left, currNum);

     if(root.left == null && root.right==null){
            totalSum = totalSum + currNum ;
        }
        helper(root.right, currNum);

4) We can also do below way but there whenever we found the leaf, we need to calculate the curr sum plus leaf root and
   then add it to the total sum.

  if(root==null)
     return ;
  if(root.left == null && root.right==null){
     totalSum = totalSum + currNum * 10 + root.val ;
    }
  currNum = currNum * 10 + root.val ;

  helper(root.left, currNum);
  //pop
  helper(root.right, currNum);
  //pop





     */
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return totalSum ;
    }
    public void helper(TreeNode root, int currNum){
        //base
        if(root==null)
            return ;
        if(root.left == null && root.right==null){
            totalSum = totalSum + currNum * 10 + root.val ;
        }
        currNum = currNum * 10 + root.val ;

        helper(root.left, currNum);
        //pop
        helper(root.right, currNum);
        //pop


    }
}