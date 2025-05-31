class Solution {
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<tokens.length;i++)
        {
            //a number
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
            {
                st.add(Integer.parseInt(tokens[i]));
            }
            else{//operator

                int x=st.pop();
                int y=st.pop();

                if(tokens[i].equals("+"))
                {
                    st.add(y+x);
                }else if(tokens[i].equals("-")){
                    st.add(y-x);
                }else if(tokens[i].equals("*")){
                    st.add(y*x);
                }else{
                    st.add(y/x);
                }
            }   
        }

        return st.pop();
        
    }
}