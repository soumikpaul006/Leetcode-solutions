class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> final_list=new ArrayList<>();

        backtrack(final_list,new ArrayList<String>(), s,0);

        return final_list;
    }
    public void backtrack(List<List<String>> final_list,ArrayList<String> temp_list, String s,int idx)
    { 
        if(idx==s.length())
        {
            final_list.add(new ArrayList<>(temp_list));
            return;
        }

        for(int i=idx;i<s.length();i++)
        {
            if(isPalindrome(s,idx,i))
            {
                temp_list.add(s.substring(idx,i+1));

                backtrack(final_list,temp_list,s,i+1);

                temp_list.remove(temp_list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int i,int j)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}