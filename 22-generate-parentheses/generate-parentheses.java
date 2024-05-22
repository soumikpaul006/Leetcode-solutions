class Solution 
{
    public List<String> list=new ArrayList<>();

    public List<String> generateParenthesis(int n) 
    {
        dfs(n,0,0,"");
        return list;   
    }
    public void dfs(int n,int open,int close,String str)
    {
        if(str.length()==2*n)
        {
            list.add(str);
            return;
        }


        if(open<n)
        {
            dfs(n,open+1,close,str+'(');
        }
        if(close<open)
        {
            dfs(n,open,close+1,str+')');
        }
    }
}