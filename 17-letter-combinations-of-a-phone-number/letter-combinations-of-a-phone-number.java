class Solution {
    public List<String> letterCombinations(String digits) 
    {
        if(digits.length()==0) return new ArrayList<>();
        List<String> final_list=new ArrayList<>();

        String[] str={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        backtrack(final_list,digits,str,new StringBuilder(),0);

        return final_list;
    
    }
    public void backtrack(List<String> final_list,String digits,String[] str,StringBuilder sb,int idx)
    {
        if(idx==digits.length())
        {
            final_list.add(sb.toString());
            return;
        }

        String s=str[digits.charAt(idx)-'0'];

        for(char c:s.toCharArray())
        {
            sb.append(c);
            backtrack(final_list,digits,str,sb,idx+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}