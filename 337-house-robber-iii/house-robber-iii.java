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
    public int rob(TreeNode root) 
    {
        int[] res=dfs(root);
        return Math.max(res[0],res[1]);
    }
    public int[] dfs(TreeNode root)
    {
        //base condition start thinking from the base condition
        //for the leaf node will return a array of size 2 having 0 for both if (rob and skip)
        if(root==null)
        {
            return new int[2];
        }

        int[] left_node=dfs(root.left);
        int[] right_node=dfs(root.right);

        int[] rob=new int[2];

        //if I rob this node the I will get the value of this node + value of its leaf node if not robbed
        //if robbed
        rob[0]=root.val+left_node[1]+right_node[1];

        //if I do not robb this node that I have many options I will take max of if robbed and max of if not robbed for iths adjacent node
        rob[1]=Math.max(left_node[0],left_node[1])+Math.max(right_node[0],right_node[1]);


        return rob;

    }
}