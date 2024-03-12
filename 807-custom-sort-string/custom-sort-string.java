class Solution
{
    public String customSortString(String s, String t)
    {
        int[] a=new int[26];    
        for(int i=0;i<t.length();i++)
        {
            char c=t.charAt(i);
            a[c-'a']++;
        }
        String ans="";
        for(int i=0;i<s.length();i++)
        {            
            char c=s.charAt(i);
            while(a[c-'a']>0)
            {
                ans+=c;
                a[c-'a']--;  
            }
        }
        for(int i=0;i<t.length();i++)
        {
            char c=t.charAt(i);
            while(a[c-'a']!=0)
            {
                ans+=c;
                a[c-'a']--;
                
            }
        }
        return ans;
        
    }
}