import java.util.*;

class Solution 
{
    public List<Integer> partitionLabels(String s) 
    {
        List<Integer> list=new ArrayList<>();
        int start=0;
        int end=0;

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);

            end=Math.max(end,s.lastIndexOf(c));

            if(i==end)
            {
                list.add(end-start+1);
                start=i+1;  
            }
        } 

        return list;
    }
}
