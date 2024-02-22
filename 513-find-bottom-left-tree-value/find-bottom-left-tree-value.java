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
    public int findBottomLeftValue(TreeNode root) 
    {
        // Queue<TreeNode> q=new LinkedList<>();
        // List<List<Integer>> final_list=new LinkedList<>();
        // q.offer(root);
        // while(!q.isEmpty())
        // {
        //     int size=q.size();
        //     List<Integer> list=new LinkedList<>();
        //     for(int i=0;i<size;i++)
        //     {
        //         if(q.peek().left!=null)
        //         {
        //             q.offer(q.peek().left);   
        //         }
        //         if(q.peek().right!=null)
        //         {
        //             q.offer(q.peek().right);
        //         }
        //         list.add(q.remove().val);
        //     }
        //     final_list.add(list);
        // }        
    
        // // System.out.print(final_list);
      
        // return final_list.get(final_list.size()-1).get(0);


        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        TreeNode r=new TreeNode();

        while(!q.isEmpty())
        {
            r=q.poll();

            if(r.right!=null)
            {
                q.offer(r.right);
            }
            if(r.left!=null)
            {
                q.offer(r.left);
            }
        }

        return r.val;


    }
}