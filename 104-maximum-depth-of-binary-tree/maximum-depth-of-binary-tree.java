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
class Solution {
    int max=0;
    public int maxDepth(TreeNode root) 
    {
        int ans=dfs(root);
        return ans;
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int left=dfs(root.left);
        int right=dfs(root.right);
       

        return 1+Math.max(left,right);

    }
}