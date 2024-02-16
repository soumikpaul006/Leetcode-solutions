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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> r_list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null) return r_list;

        q.offer(root);
        
        while(!q.isEmpty())
        {   
            int level_size=q.size();
            List<Integer> sub_list=new LinkedList<>();

            for(int i=0;i<level_size;i++)
            {
                if(q.peek().left!=null)
                {
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null)
                {
                    q.offer(q.peek().right);
                }
                sub_list.add(q.remove().val);
            }
            r_list.add(sub_list.get(sub_list.size()-1));

        }

        return r_list;
    }
}