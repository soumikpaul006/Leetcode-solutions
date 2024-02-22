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
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {

        if(root==null) return new ArrayList<>();
        List<List<Integer>> final_list=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        boolean counter=false;

        while(!q.isEmpty())
        {
            int size=q.size();

            LinkedList<Integer> list=new LinkedList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode node=q.remove();
                if(!counter)//false//odd level ; 1,3,5. left->right
                {
                  list.addLast(node.val);
                }
                else//true//even level ;2,4,6. right->left
                { 
                   list.addFirst(node.val);
                } 

                if(node.left!=null)
                {
                    q.offer(node.left);
                }
                if(node.right!=null)
                {
                    q.offer(node.right);
                }  
            }

            counter=!counter;
            final_list.add(list);
        }

        return final_list;       
    }
}