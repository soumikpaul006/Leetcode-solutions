class Solution {
    public int minFallingPathSum(int[][] matrix) 
    {
        int min=Integer.MAX_VALUE;

        Integer[][] dp=new Integer[matrix.length][matrix[0].length];

        // for(int i=0;i<dp.length;i++)
        // {
        //     for(int j=0;j<dp[i].length;j++)
        //     {
        //         dp[i][j]=-1;
        //     }
        // }

		for(int i=0;i<matrix[0].length;i++)
		{
			int temp_min=helper(matrix,0,i,dp);
			min=Math.min(min,temp_min);
		}

		return min;
        
    }
    public static int helper(int[][] num,int i,int j,Integer[][] dp)
	{
		//base
		if(i==num.length-1)
		{
			return num[i][j];
		}

        if(dp[i][j]!=null) return dp[i][j];

		int one=Integer.MAX_VALUE;

		if(j>0)
		{
			one=helper(num,i+1,j-1,dp); //left diagonal
		}
		
		int two=helper(num,i+1,j,dp); //down

		int three=Integer.MAX_VALUE;

		if(j<num[0].length-1)
		{
			three=helper(num,i+1,j+1,dp); //right diagonal
		}

		return dp[i][j]=Math.min(one,Math.min(two,three))+num[i][j];

	} 
}