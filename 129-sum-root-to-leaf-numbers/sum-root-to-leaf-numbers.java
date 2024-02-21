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
    int sum=0;
    public int sumNumbers(TreeNode root) 
    {
        dfs(root,"");
        return sum;
    }
    public void dfs(TreeNode root,String str)
    {
        if(root==null){
            return;
        }

        str+=String.valueOf(root.val);

        if(root.left==null && root.right==null){
            sum+=Integer.valueOf(str);
            return;
        }

        dfs(root.left,str);
        dfs(root.right,str);

    }
}