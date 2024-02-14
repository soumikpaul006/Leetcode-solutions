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

 //TC: O(N)  /////Time Optimised
class Solution 
{
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        dfs(root);
        return max; 
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int left=dfs(root.left);
        int right=dfs(root.right);
       
        max=Math.max(max,left+right);

        return 1+Math.max(left,right);

    }
}
//TC:O(N^2) //Brute Force

// class Solution 
// {
//     int max=0;
//     public int diameterOfBinaryTree(TreeNode root) 
//     {
//         if(root==null)
//         {
//             return 0;
//         }

//         int left=height(root.left);
//         int right=height(root.right);

//         max=Math.max(max,left+right);

//         diameterOfBinaryTree(root.left);
//         diameterOfBinaryTree(root.right);

//         return max;
        
//     }
//     public int height(TreeNode root)
//     {
//         if(root==null)
//         {
//             return 0;
//         }

//         int left=height(root.left);
//         int right=height(root.right);
       

//         return 1+Math.max(left,right);

//     }
// }


