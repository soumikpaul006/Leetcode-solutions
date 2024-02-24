class Solution {
    public boolean isAlienSorted(String[] words, String order) 
    {

        // mapping each caharacter of the order string to its index

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++)
        {
            map.put(order.charAt(i),i);
        }

        // if(words.length==2)
        // {   
        //     int len1=words[0].length();
        //     int len2=words[1].length();

        //     int size=len1<=len2?len1:len2;

            

        //     for(int i=0;i<size;i++)
        //     {
        //         char c1=words[0].charAt(i);
        //         char c2=words[1].charAt(i);

        //         if(c1==c2)
        //         {
        //             continue;
        //         }
        //         if(c1!=c2 && map.get(c1)>map.get(c2))
        //         {
        //             return false;
        //         }
        //         if(c1!=c2 && map.get(c1)<map.get(c2))
        //         {
        //             return true;
        //         }
        //     }    
        // }

        for(int i=0;i<words.length-1;i++)
        {   
            String str1=words[i];
            String str2=words[i+1];

            int len1=str1.length();
            int len2=str2.length();

            int size=len1<=len2?len1:len2;

            // if(len2<len1) return false;

             if (len1 > len2 && str1.startsWith(str2)) {
                return false;
            }

            for(int j=0;j<size;j++)
            {

                // if(j>=str2.length()) return false;

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