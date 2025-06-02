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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> final_list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null) return final_list;

        q.offer(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> list=new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                if(q.peek().left!=null)
                {
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null)
                {
                    q.offer(q.peek().right);
                }
                list.add(q.remove().val);
            }

            final_list.add(list.get(list.size()-1));
        } 

        return final_list;
        
    }
}