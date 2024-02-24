class Solution 
{
    public void solve(char[][] board) 
    {   
        int row=board.length;
        int col=board[0].length;
        

        //applying dfs on all 4 edges

        //1st col
        for(int i=1;i<row-1;i++)
        {
            if(board[i][0]=='O')
            {
                dfs(board,i,0);
            }
        }

        //last col
        for(int i=1;i<row-1;i++)
        {
            if(board[i][col-1]=='O')
            {
                dfs(board,i,col-1);
            }
        }

        //1st row
        for(int i=1;i<col-1;i++)
        {
            if(board[0][i]=='O')
            {
                dfs(board,0,i);
            }
        }

        //last row
        for(int i=1;i<col-1;i++)
        {
            if(board[row-1][i]=='O')
            {
                dfs(board,row-1,i);
            }
        }


        
        //convert all the Y-> O and O->X;
        for(int i=1;i<row-1;i++)
        {
            for(int j=1;j<col-1;j++)
            {
                if(board[i][j]=='Y')
                {
                    board[i][j]='O';
                }
                else if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }

        //convert the Y->O in both the edge rows 
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


        //convert the Y->O in both the edge cols 
        for(int j=0;j<col;j++)
        {
            if(board[0][j]=='Y')
            {
                board[0][j]='O';
            }
            if(board[row-1][j]=='Y')
            {
                board[row-1][j]='O';
            }
        }

  
    }
    public void dfs(char[][] grid, int i,int j)
    {
        //base
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]!='O')
        {
            return;
        }

        grid[i][j]='Y';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}