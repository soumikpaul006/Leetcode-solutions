class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        if(image[sr][sc]==color) return image;

        int start_color=image[sr][sc];

        dfs(image,sr,sc,start_color,color);

        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int start_color,int color)
    {
        if(sr<0||sc<0||sr>image.length-1||sc>image[0].length-1||image[sr][sc]!=start_color)
        {
            return;
        }

        image[sr][sc]=color;

        dfs(image,sr+1,sc,start_color,color);
        dfs(image,sr-1,sc,start_color,color);
        dfs(image,sr,sc+1,start_color,color);
        dfs(image,sr,sc-1,start_color,color);

    }
}