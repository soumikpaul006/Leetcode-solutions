class Solution 
{
    public String longestPalindrome(String s) 
    {


        if(s.length()==1) return s;
        int len=s.length();
        boolean[][] dp=new boolean[len][len];

        //1
        for(int i=0;i<len;i++)
        {
            dp[i][i]=true;
        }


        int start=0;
        int end=0;

        //2
        for(int i=0;i<len-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=true;
                start=i;
                end=i+1;
            }
        }


        //2 and more gap
        for(int gap=2;gap<len;gap++)
        {
            for(int j=0;j<len-gap;j++)
            {
                int a=j;
                int b=a+gap;

                if(s.charAt(a)==s.charAt(b) && dp[a+1][b-1]==true)
                {
                    dp[a][b]=true;

                    if(b-a>end-start)
                    {
                        start=a;
                        end=b;
                    }
                }
            }
        }

        return s.substring(start,end+1);
 
    }
}