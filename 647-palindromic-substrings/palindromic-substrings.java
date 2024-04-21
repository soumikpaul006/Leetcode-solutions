class Solution {
    public int countSubstrings(String s) 
    {
        if(s.length()==1) return 1;
        
        int len=s.length();
        boolean[][] dp=new boolean[len][len];

        int count=0;

        //1
        for(int i=0;i<len;i++)
        {
            dp[i][i]=true;
            count++;
        }
       

        //2
        for(int i=0;i<len-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=true;
                count++;
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
                    count++;
                }
            }
        }

        return count;  
    }
}