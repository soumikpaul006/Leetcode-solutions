class Solution {
    public List<String> generateParenthesis(int n) 
    {
        List<String> final_list = new ArrayList<>();

        backtrack(final_list, 0,0,"",n);
        return final_list;
    }
    public void backtrack(List<String> final_list, int open,int close,String s,int n)
    {
        //base
        if(s.length()==n*2)
        {
            final_list.add(s);
            return;
        }

        //equation
        if(open<n)
        {
            backtrack(final_list,open+1,close,s+'(',n);
        }
        if(close<open){
            backtrack(final_list,open,close+1,s+')',n);
        }

    }
}