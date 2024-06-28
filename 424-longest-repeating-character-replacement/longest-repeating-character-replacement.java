class Solution {
    public int characterReplacement(String s, int k) 
    {
        int l=0;
        int r=0;
        int res=0;

        int[] arr=new int[26];

        while(r<s.length())
        {
            arr[s.charAt(r)-'A']++;

            if((r-l+1)-max_freq(arr)<=k)
            {
                res=Math.max(res,(r-l+1));
            }
            else{

                arr[s.charAt(l)-'A']--;
                l++;
            }

            r++;

        }

        return res;
        
    }
    public int max_freq(int[] arr)
    {
        int max=Integer.MIN_VALUE;

        for(int i=0;i<26;i++)
        {
            max=Math.max(max,arr[i]);
        }

        return max;
    }
}