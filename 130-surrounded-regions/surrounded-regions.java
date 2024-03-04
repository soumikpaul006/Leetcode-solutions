class Solution 
{
    public void solve(char[][] board) 
    {   
        int row=board.length;
        int col=board[0].length;

        //Apply dfs at every edges

        //TOP ROW & BOTTOM ROW
        for(int i=0;i<col;i++)
        {
            if(board[0][i]=='O')
            {
                dfs(board,0,i);
            }
            if(board[row-1][i]=='O')
            {
                dfs(board,row-1,i);
            }
        }

        //LEFT COLUMN AND RIGHT COLUMN
        for(int i=0;i<row;i++)
        {
            if(board[i][0]=='O')
            {
                dfs(board,i,0);
            }
            if(board[i][col-1]=='O')
            {
                dfs(board,i,col-1);
            }
        }

        //covert O-> X and Y-> O in the middle of the matrix

        for(int i=1;i<row-1;i++)
        {
            for(int j=1;j<col-1;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                if(board[i][j]=='Y')
                {
                    board[i][j]='O';
                }
            }
        }

        //Converting Ys in the edges O
        for(int i=0;i<col;i++)
        {
            if(board[0][i]=='Y')
            {
                board[0][i]='O';
            }
            if(board[row-1][i]=='Y')
            {
                board[row-1][i]='O';
            }
        }

        //Converting Ys in the edges O
        for(int i=0;i<row;i++)
        {
            if(board[i][0]=='Y')
            {
                board[i][0]='O';
            }
            if(board[i][col-1]=='Y')
            {
                board[i][col-1]='O';
            }
        } 
    }
    public void dfs(char[][] board,int i,int j)
    {
        if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]!='O')
        {
            return;
        }

        board[i][j]='Y';

        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}