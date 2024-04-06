class Solution
{
    public String minRemoveToMakeValid(String s)
    {

        if(s==null||s.isEmpty()) return s;
        Stack<Integer> stack=new Stack<>();
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='(')
            {
                stack.push(i);
            }
            if(c[i]==')')
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else {
                    c[i]=' ';
                }
            }
        }
        while(!stack.isEmpty())
        {
            c[stack.pop()]=' ';
        }
        return String.valueOf(c).replaceAll(" ","");
    }
}