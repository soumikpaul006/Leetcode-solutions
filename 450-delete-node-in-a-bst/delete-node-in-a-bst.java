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
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        if(root==null) return null;

        if(key<root.val)
        {
            root.left= deleteNode(root.left,key); //traverse left
        }
        else if(key> root.val){
            root.right= deleteNode(root.right,key); //traverse right
        }
        else{//if  key==root.val
            if(root.left==null && root.right==null)
            {
                return null;
            } 
            else if(root.left==null) //if the node that we are suppose to delete has no left child
            {
                return root.right;
            }
            else if(root.right==null) //if the node that we are suppose to delete has no right child
            {
                return root.left;
            }
            else{ //if the node that we are suppose to delete has two child

                TreeNode node=root.right;
                while(node.left!=null)
                {
                    node=node.left;
                }

                node.left=root.left;

                return root.right;
            }
        }

        return root;
        
    }
}