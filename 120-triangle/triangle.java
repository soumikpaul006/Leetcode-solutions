class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int[][] dp=new int[triangle.size()][triangle.size()];

        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                dp[i][j]=-1;
            }
        }

        return helper(triangle,0,0,dp);
    }
    public int helper(List<List<Integer>> triangle,int i,int j,int[][] dp)
    {
        //base
        if(i==triangle.size()-1)
        {
            return triangle.get(i).get(j);
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int one=helper(triangle,i+1,j,dp);
        int two=helper(triangle,i+1,j+1,dp);

        return dp[i][j]=Math.min(one,two)+triangle.get(i).get(j);

    }
}