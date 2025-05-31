class Solution 
{
    public List<String> final_list=new ArrayList<>();

    public List<String> generateParenthesis(int n) 
    {
        
        dfs(final_list,0,0,n,"");

        return final_list;
    
    }
    public void dfs(List<String> final_list,int open,int close,int n,String str)
    {
        if(str.length()==n*2)//base 
        {
            // System.out.println(str);
            final_list.add(str);
        }

        if(open<n)
        {
            dfs(final_list,open+1,close,n,str+"(");
        }

        if(close<open)
        {
            dfs(final_list,open,close+1,n,str+")");
        }

    }
    
}