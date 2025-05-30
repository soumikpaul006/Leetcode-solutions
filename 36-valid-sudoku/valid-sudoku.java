class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        Set<String> set=new HashSet<>();

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                char c=board[i][j];

                if(c!='.')
                {
                    if(!set.add("row"+c+i)||!set.add("col"+c+j)||!set.add("box"+c+i/3+j/3))
                    {
                        return false;
                    }
                }
            }
        }

        return true;   
    }
}