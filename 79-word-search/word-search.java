class Solution 
{
    public boolean exist(char[][] board, String word) 
    {
        int row=board.length;
        int col=board[0].length;

        boolean[][] visited=new boolean[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(board,word,i,j,visited,0))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public boolean dfs(char[][] board,String word,int i,int j,boolean[][] visited,int counter)
    {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || visited[i][j])
        {
            return false;
        }

        if(board[i][j]!=word.charAt(counter))
        {
            return false;
        }

        visited[i][j]=true;

        if(counter==word.length()-1) return true;

        boolean found=dfs(board,word,i+1,j,visited,counter+1)||
        dfs(board,word,i-1,j,visited,counter+1)||
        dfs(board,word,i,j-1,visited,counter+1)||
        dfs(board,word,i,j+1,visited,counter+1);

        visited[i][j]=false;

        return found;
    }
}