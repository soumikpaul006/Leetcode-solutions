class Solution 
{
    public List<List<String>> partition(String s) 
    {
        List<List<String>> final_list=new ArrayList<>();

        backtrack(final_list,new ArrayList<>(),s,0);
        return final_list;
        
    }
    public void backtrack(List<List<String>> final_list, List<String> new_list, String s,int start)
    {
        if(start==s.length())
        {
            final_list.add(new ArrayList<>(new_list));
            return;
        }
        

        for(int i=start;i<s.length();i++)
        {

            if(isPalindrome(s,start,i))
            {
                new_list.add(s.substring(start,i+1));

                backtrack(final_list,new_list,s,i+1);
                
                new_list.remove(new_list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str,int i,int j)
    {
      
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}