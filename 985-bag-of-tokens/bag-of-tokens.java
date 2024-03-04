class Solution {
    public int bagOfTokensScore(int[] tokens, int power) 
    {

        if(tokens.length==0 || tokens.length==1 && power<tokens[0]) return 0;

        int score=0;

        int i=0;
        int j=tokens.length-1;

        Arrays.sort(tokens);

        if(tokens[0]>power) return 0;

        int ans=0;

        while(i<=j)
        {
            if(power>=tokens[i])
            {
                power-=tokens[i];
                i++;
                score++;
            }
            else if(score>0)
            {
                power+=tokens[j];
                j--;
                score--;
            }
            ans=Math.max(score,ans);
            System.out.println(score);
        }

        return ans;
        
    }
}