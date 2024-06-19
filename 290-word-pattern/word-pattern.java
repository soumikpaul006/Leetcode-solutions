class Solution {
    public boolean wordPattern(String pattern, String s) 
    {
        HashMap<Character,String> map=new HashMap<>();

        String[] str=s.split(" ");

        if(str.length!=pattern.length()) return false;

        for(int i=0;i<pattern.length();i++)
        {
            if(map.containsKey(pattern.charAt(i)))
            {
                if(!map.get(pattern.charAt(i)).equals(str[i]))
                {
                    return false;
                }
            }
            else{
                if(map.containsValue(str[i])) return false;

                map.put(pattern.charAt(i),str[i]);
            }
        }   

        return true;    
    }
}