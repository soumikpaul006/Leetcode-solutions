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
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> r_list=new ArrayList<>();

        if(root==null) return r_list;


        q.offer(root);

        while(!q.isEmpty())
        {
            int num=q.size();
            List<Integer> subList=new LinkedList<>();
            for(int i=0;i<num;i++)
            {
                if(q.peek().left!=null)
                {
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null)
                {
                    q.offer(q.peek().right);
                }
                subList.add(q.remove().val);
            }

            r_list.add(subList.get(subList.size()-1));
        
        }

        return r_list;
    }

}