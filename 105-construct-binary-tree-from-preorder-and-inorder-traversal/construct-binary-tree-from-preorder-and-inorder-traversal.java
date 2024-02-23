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
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        TreeNode node=helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);

        return node;
    }
    public TreeNode helper(int[] preorder,int startPre,int endPre,int[] inorder,int startIn,int endIn,HashMap<Integer,Integer> map)
    {
        //base
        if(startPre>endPre || startIn>endIn)
        {
            return null;
        }

        TreeNode node=new TreeNode(preorder[startPre]);

        node.left=helper(preorder,startPre+1,startPre+map.get(node.val)-startIn,inorder,startIn,map.get(node.val)-1,map);
        node.right=helper(preorder,startPre+map.get(node.val)-startIn+1,endPre,inorder,map.get(node.val)+1,endIn,map);

        return node;
    }
}