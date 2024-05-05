class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {

        if(triangle.size()==1) return triangle.get(0).get(0);

        int[][] dp=new int[triangle.size()][triangle.size()];

        //base
        for(int i=0;i<triangle.size();i++)
        {   
            //assign the last row of dp == last row of triangle as it is
            dp[triangle.size()-1][i]=triangle.get(triangle.size()-1).get(i);
        }

        for(int i=triangle.size()-2;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
            {
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
    
}