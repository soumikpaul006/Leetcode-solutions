class Solution {
    public int characterReplacement(String s, int k) 
    {
        int[] arr=new int[26];

        int l=0;
        int r=0;

        int max=Integer.MIN_VALUE;

        while(r<s.length())
        {
            arr[s.charAt(r)-'A']++;

            if((r-l+1)-maxFreq(arr)<=k) //if valid
            {
                max=Math.max(max,r-l+1);

            }else{ //not valid

                arr[s.charAt(l)-'A']--;
                l++;
            }   

            r++;
        }

        return max;
    }
    public int maxFreq(int[] arr)
    {
        int max=Integer.MIN_VALUE;

        for(int x:arr)
        {
            max=Math.max(max,x);
        }

        return max;
    }
}