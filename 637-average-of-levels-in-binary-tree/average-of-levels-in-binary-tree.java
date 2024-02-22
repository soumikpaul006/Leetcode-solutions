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
    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<List<Integer>> final_list=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        List<Double> ans=new ArrayList<>();

        while(!q.isEmpty())
        {
            int size=q.size();

            List<Integer> list=new LinkedList<>();
            
            double sum=0.0;
            
            for(int i=0;i<size;i++)
            {   
                sum+=q.peek().val;
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
            final_list.add(list);
            ans.add(sum/size);
        }

        System.out.println(final_list);
        System.out.println(ans);


        return ans;
   
    }
}