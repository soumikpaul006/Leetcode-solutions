class Solution 
{
    public String str="";
    public boolean exist(char[][] board, String word) 
    {
        int row=board.length;
        int col=board[0].length;
        boolean[][] visited=new boolean[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(dfs(board,word,visited,i,j,0))
                {
                    return true;
                }
            }
        }

        return false;   
    }
    public boolean dfs(char[][] board,String word,boolean[][] visited,int i,int j,int k)
    { 
        if(i<0||j<0||i>board.length-1||j>board[0].length-1|| visited[i][j] || board[i][j]!=word.charAt(k))
        {
            return false;
        }

        visited[i][j]=true;

        if(k==word.length()-1)
        {
            return true;
        }

       
        boolean found = dfs(board,word,visited,i+1,j,k+1)||
                        dfs(board,word,visited,i-1,j,k+1)||
                        dfs(board,word,visited,i,j-1,k+1)||
                        dfs(board,word,visited,i,j+1,k+1);

        visited[i][j]=false;

        return found;

    }
}