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
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        TreeNode node=helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);

        return node;
    }
    public TreeNode helper(int[] postorder,int startPos,int endPos,int[] inorder,int startIn,int endIn,HashMap<Integer,Integer> map)
    {
        //base
        if(startPos>endPos || startIn>endIn)
        {
            return null;
        }

        TreeNode node=new TreeNode(postorder[endPos]);

        node.left=helper(postorder,startPos,startPos+map.get(node.val)-startIn-1,inorder,startIn,map.get(node.val)-1,map);
        node.right=helper(postorder,startPos+map.get(node.val)-startIn,endPos-1,inorder,map.get(node.val)+1,endIn,map);

        return node;
    }
}