class Solution 
{
    public String customSortString(String order, String s)
    {
        int[] arr=new int[26];

        //freq_count of s
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']++;
        }

        String ans="";

        for(int i=0;i<order.length();i++)
        {
           while(arr[order.charAt(i)-'a']>0)
            {
                ans+=order.charAt(i);
                arr[order.charAt(i)-'a']--;
            }
        
        }

        for(int i=0;i<s.length();i++)
        {
            while(arr[s.charAt(i)-'a']>0)
            {
                ans+=s.charAt(i);
                arr[s.charAt(i)-'a']--;
            }
        }

        return ans;


    }
}