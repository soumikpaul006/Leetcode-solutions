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

//TC: O(N) //Time Optimised

 class Solution {
    public boolean isBalanced(TreeNode root) 
    {
        return dfs(root)!=-1;

    }
    public int dfs(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int left=dfs(root.left);
        int right=dfs(root.right);

        if(left==-1 || right==-1) return -1;

        if(Math.abs(left-right)>1)
        {
            return -1;
        } 
        
        return 1+Math.max(left,right);
    }
 }

//TC:  O(N^2) //Brute Force
// class Solution {
//     public boolean isBalanced(TreeNode root) 
//     {
//         if(root==null) return true;

//         int left=height(root.left);
//         int right=height(root.right);

//         if(Math.abs(left-right)>1)
//         {
//             return false;
//         } 

//         return isBalanced(root.left) && isBalanced(root.right);
//     }
//     public int height(TreeNode root)
//     {
//         if(root==null) return 0;

//         int left=height(root.left);
//         int right=height(root.right);

//         return 1+Math.max(left,right);
//     }
// }