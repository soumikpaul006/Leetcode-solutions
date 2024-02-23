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
    class Pair
    {
        TreeNode node;
        int idx;

        Pair(TreeNode node,int idx)
        {
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) 
    {
        if(root==null) return 0;
        int max=Integer.MIN_VALUE;
        Queue<Pair> q=new LinkedList<>();
        // List<List<Integer>> final_list=new LinkedList<>();

        q.offer(new Pair(root,1));

        while(!q.isEmpty())
        {
            int size=q.size();

            List<Integer> list=new LinkedList<>();

            int startIdx=q.peek().idx;
            
            for(int i=0;i<size;i++)
            {
                if(q.peek().node.left!=null)
                {
                    q.offer(new Pair(q.peek().node.left,2*(q.peek().idx-1)+1));
                }
                if(q.peek().node.right!=null)
                {
                    q.offer(new Pair(q.peek().node.right,2*(q.peek().idx-1)+2));
                }

                if(i==size-1)
                {
                    max=Math.max(max,q.peek().idx-startIdx+1);
                }

                // list.add(q.remove().node.val);
                q.remove();
            }

            // final_list.add(list);
        }

        // System.out.print(final_list);

        return max;
    }
}