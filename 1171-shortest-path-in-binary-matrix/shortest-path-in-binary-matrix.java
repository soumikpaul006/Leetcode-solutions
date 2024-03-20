import java.util.*;

class Solution 
{
    class Pair
    {
        int weight;
        int row;
        int col;

        Pair(int weight, int row, int col) 
        {
            this.weight = weight;
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int row = grid.length;
        int col = grid[0].length;

        if(row==1 && col==1 && grid[0][0]==0) return 1;

        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[row][col];

        for (int i = 0;i<row;i++) 
        {
            for(int j=0;j<col;j++)
            {
                dist[i][j]=(int)(1e9);
            }
        }

        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1) 
        {
            return -1; // Check if the start or end cell is blocked
        }

        dist[0][0] = 0;
        q.add(new Pair(1, 0, 0));

        int[] delrow = { +1, 0, -1, 0, +1, -1, +1, -1 }; // Updated for 8 directions
        int[] delcol = { 0, +1, 0, -1, +1, +1, -1, -1 }; // Updated for 8 directions

        while (!q.isEmpty()) 
        {
            Pair pair = q.remove();
            int wt = pair.weight;
            int r = pair.row;
            int c = pair.col;

            for (int i = 0; i < 8; i++) 
            {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < row && ncol < col && grid[nrow][ncol] == 0 && dist[nrow][ncol] > wt + 1) 
                {                   
                    dist[nrow][ncol] = wt + 1;
                    q.add(new Pair(wt + 1, nrow, ncol));

                    if (nrow == row - 1 && ncol == col - 1) 
                    {
                        return wt + 1;
                    }
                }

            }

        }

        return -1;
    }
}
