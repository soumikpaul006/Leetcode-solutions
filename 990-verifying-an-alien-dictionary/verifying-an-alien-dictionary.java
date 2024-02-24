class Solution {
    public boolean isAlienSorted(String[] words, String order) 
    {

        // mapping each caharacter of the order string to its index

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++)
        {
            map.put(order.charAt(i),i);
        }

        for(int i=0;i<words.length-1;i++)
        {   
            String str1=words[i];
            String str2=words[i+1];

            int len1=str1.length();
            int len2=str2.length();

            int size=len1<=len2?len1:len2;

           

            if (len1 > len2 && str1.startsWith(str2)) {
                return false;
            }

            for(int j=0;j<size;j++)
            {

                char c1=str1.charAt(j);
                char c2=str2.charAt(j);

                if(j==0 && c1!=c2 && map.get(c1)<map.get(c2))
                {
                    break;
                } 
                if(c1==c2 || (c1!=c2 && map.get(c1)<map.get(c2)))
                {
                    continue;
                }
                else if(c1!=c2 && map.get(c1)>map.get(c2))
                {
                    return false;
                }
               
            }
        }

        return true;  
    }
}