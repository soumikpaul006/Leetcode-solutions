class Solution 
{
    public List<String> final_list=new ArrayList<>();
    public String[] str_arr=new String[]{" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) 
    {
        if(digits.length()==0)
        {
            return new ArrayList<>();
        } 

        helper(0,digits,new StringBuilder());
        return final_list;

    }
    public void helper(int idx,String digits,StringBuilder sb)
    {
        //base condition
        if(idx==digits.length())
        {
            final_list.add(sb.toString());
            return;
        }

        //equation
        char key=digits.charAt(idx);
        String str=str_arr[key-'0'];

        for(char c:str.toCharArray())
        {
            sb.append(c);
            helper(idx+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}