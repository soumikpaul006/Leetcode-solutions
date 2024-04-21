class Solution 
{
    public String longestPalindrome(String s) 
    {
        if (s.length() <= 1) return s;

        int maxLen = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) 
        {
            for (int j = i; j < s.length(); j++) 
            {
                if (isPalindrome(s, i, j)) 
                {
                    int len = j - i + 1;
                    if (len > maxLen)
                    {
                        maxLen = len;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public boolean isPalindrome(String s, int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            else{
                start++;
                end--;
            }
        }

        return true;
    }
}