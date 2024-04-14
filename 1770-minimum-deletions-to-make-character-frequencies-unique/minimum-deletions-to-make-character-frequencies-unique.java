class Solution {
    public int minDeletions(String s) 
    {
        int[] freq=new int[26];

        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }

        HashSet<Integer> set=new HashSet<>();

        int del=0;

        for(int i=0;i<freq.length;i++)
        {
            while(freq[i]!=0 && !set.add(freq[i]))
            {
                freq[i]--;
                del++;

            }
        }
        
        return del;
    }
}