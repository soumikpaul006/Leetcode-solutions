class Solution {
    public int minFallingPathSum(int[][] num) 
    {
        //base
        int[][] dp=new int[num.length][num.length];

        for(int i=0;i<num.length;i++)
        {
            dp[num.length-1][i]=num[num.length-1][i]; //asign the last row of the dp as the last row of the num
        }

        for(int i=num.length-2;i>=0;i--)
        {
            for(int j=0;j<num.length;j++)
            {
                int one=Integer.MAX_VALUE;
                if(j>0)
                {
                    one=dp[i+1][j-1]; //left diagonal
                }

                int two=dp[i+1][j]; //down

                int three=Integer.MAX_VALUE;

                if(j<num[0].length-1)
                {
                    three=dp[i+1][j+1]; //right diagonal
                }

                dp[i][j]=Math.min(one,Math.min(two,three))+num[i][j];

            }
        }


        int min=Integer.MAX_VALUE;

		for(int i=0;i<num[0].length;i++)
		{
			min=Math.min(min,dp[0][i]);
		}

		return min;
        
    }

}