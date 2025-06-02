/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    public boolean hasPathSum(TreeNode root, int targetSum) 
    {
        if(root==null && targetSum==0) return false;
        return dfs(root,targetSum);
    }
    public boolean dfs(TreeNode root,int targetSum)
    {
        if(root==null)
        {
            return false;
        }

        if(root.left==null && root.right==null && targetSum==root.val)
        {
            return true;
        }

        return dfs(root.left,targetSum-root.val)||dfs(root.right,targetSum-root.val);
    }
    
}