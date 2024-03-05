class Solution {

    int count=0;
    public int numEnclaves(int[][] board) 
    {
        int row=board.length;
        int col=board[0].length;

        //Apply dfs at every edges

        //TOP ROW & BOTTOM ROW
        for(int i=0;i<col;i++)
        {
            if(board[0][i]==1)
            {
                dfs(board,0,i);
            }
            if(board[row-1][i]==1)
            {
                dfs(board,row-1,i);
            }
        }

        //LEFT COLUMN AND RIGHT COLUMN
        for(int i=0;i<row;i++)
        {
            if(board[i][0]==1)
            {
                dfs(board,i,0);
            }
            if(board[i][col-1]==1)
            {
                dfs(board,i,col-1);
            }
        }


        // for(int i=0;i<row;i++)
        // {
        //     for(int j=0;j<col;j++)
        //     {
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        //APPROACH 1

        // int count=0;

        // for(int i=1;i<row-1;i++)
        // {
        //     for(int j=1;j<col-1;j++)
        //     {
        //         if(board[i][j]==1)
        //         {
        //             count=0;
        //             count+=dfs_count(board,i,j);
        //         }
        //     }
        // }

        //APPROACH 2

         for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                count+=board[i][j];
            }
        }

        // System.out.println();

        // for(int i=0;i<row;i++)
        // {
        //     for(int j=0;j<col;j++)
        //     {
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return count;
    }
    public void dfs(int[][] board,int i,int j)
    {
        if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]!=1)
        {
            return;
        }

        // board[i][j]=2;
        board[i][j]=0;


        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
    // public int dfs_count(int[][] board,int i,int j)
    // {
    
    //     if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]!=1)
    //     {
    //         return 0;
    //     }

    //     if(board[i][j]==1)
    //     {
    //         count++;
    //     }

    //     board[i][j]=3;

    //     dfs_count(board,i+1,j);
    //     dfs_count(board,i-1,j);
    //     dfs_count(board,i,j+1);
    //     dfs_count(board,i,j-1);

    //     return count;
    // }
}