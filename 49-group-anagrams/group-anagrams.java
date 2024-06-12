class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        // ArrayList<ArrayList<String>> final_list=new List<>();
        HashMap<String,List<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++)
        {
            //sort the string
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            String new_string=String.valueOf(ch);

            if(map.containsKey(new_string))
            {
                map.get(new_string).add(strs[i]);
            }
            else{
                map.put(new_string,new ArrayList<>());
                map.get(new_string).add(strs[i]);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }
}