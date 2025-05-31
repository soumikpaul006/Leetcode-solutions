class Solution {
    public boolean isValid(String s) 
    {
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);

            if(c=='(' || c=='{' || c=='['){ //opening

                st.add(c);
            }   
            else{//closing
                if(st.isEmpty()) return false;

                char ch=st.pop();

                if((c==')' && ch!='(' ) || (c=='}' && ch!='{') || (c==']' && ch!='['))
                {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}