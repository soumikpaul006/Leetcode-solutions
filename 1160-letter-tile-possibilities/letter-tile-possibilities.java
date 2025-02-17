class Solution {
    int count=0;
    public int numTilePossibilities(String tiles) 
    {
        char[] charArray=tiles.toCharArray();

        Arrays.sort(charArray);

        boolean[] used=new boolean[tiles.length()];
        backtrack(charArray,used);

        return count-1;
    }

    public void backtrack(char charArray[], boolean used[]) 
    {
        count++;

        for(int i=0;i<charArray.length;i++)
        {
            if(used[i] || (i>0 && charArray[i]==charArray[i-1] && !used[i-1]))
            {
                continue;
            }

            used[i]=true;
            backtrack(charArray,used);
            used[i]=false;
        }
        
    }
}