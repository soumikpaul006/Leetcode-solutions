class Solution {
    public int lengthOfLongestSubstring(String s) 
    {

        if(s.length()==0) return 0;

        Set<Character> set=new HashSet<>();
        int max=Integer.MIN_VALUE;

        int i=0;
        int j=0;

        while(j<s.length())
        {
            while(set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j++));
            max=Math.max(max,j-i);
        }

        return max;
    }
}
