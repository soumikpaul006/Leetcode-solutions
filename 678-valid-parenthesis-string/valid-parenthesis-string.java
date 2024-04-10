import java.util.*;

class Solution 
{
    class Pair
    {
        char first;
        int second;

        Pair(char first,int second)
        {
            this.first=first;
            this.second=second;
        }

    }

    public boolean checkValidString(String s) 
    {

        // TC: O(n) ; SC: O(n)
        Stack<Pair> open_stack = new Stack<>();
        Stack<Pair> star_stack = new Stack<>();


        for(int i=0;i<s.length();i++)
        {

            if(s.charAt(i)=='(')
            {
                open_stack.add(new Pair('(',i));

            }else if(s.charAt(i)=='*'){

                star_stack.add(new Pair('*',i));
            }


            else if(s.charAt(i)==')')
            {
                if(!open_stack.isEmpty())
                {
                    open_stack.pop();
                }

                else if(!star_stack.isEmpty())
                {
                    star_stack.pop();
                }
                else
                {
                    return false;
                }            
            }
        }

        while(!open_stack.isEmpty())
        {
            if(!star_stack.isEmpty() && (open_stack.peek().second<star_stack.peek().second) )
            {
                open_stack.pop();
                star_stack.pop();

            }else{
                return false;
            }
        }
        
        return open_stack.isEmpty();  
    }
}