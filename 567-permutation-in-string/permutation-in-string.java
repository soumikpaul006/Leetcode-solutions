class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        if(s1.length()>s2.length()) return false;

        int[] arr1=new int[26];

        for(int i=0;i<s1.length();i++)
        {
            arr1[s1.charAt(i)-'a']++;
        }

        // int[] arr2=new int[26];
        


        int l=0;
        int r=s1.length()-1;

        while(r<s2.length())
        {
            int[] arr2=new int[26];

            for(int i=l;i<=r;i++)
            {
                arr2[s2.charAt(i)-'a']++;
            }

            if(check(arr1,arr2))
            {
                return true;
            }
            l++;
            r++;
        }

        return false;

        
    }
    public boolean check(int[] arr1,int[] arr2)
    {
        for(int i=0;i<26;i++)
        {
            if(arr1[i]!=arr2[i])
            {
                return false;
            }
        }

        return true;
    }
}