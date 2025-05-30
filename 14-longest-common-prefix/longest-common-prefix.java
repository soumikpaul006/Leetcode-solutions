class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        if(strs.length==1) return strs[0];

        Arrays.sort(strs);

        String s1=strs[0];
        String s2=strs[strs.length-1];

        int i=0;
        int j=0;

        StringBuilder sb=new StringBuilder();

        while(i<s1.length() && j<s2.length())
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                sb.append(s1.charAt(i));
                i++;
                j++;
            }else{
                break;
            }
            
        }

        return sb.toString();
    }
}