class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<String,List<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++)
        {
            String s=strs[i];
            char[] str=s.toCharArray();

            Arrays.sort(str);

            String st=String.valueOf(str);

            if(!map.containsKey(st))
            {
                map.put(st,new ArrayList<>());
                map.get(st).add(s);
            }else{
                map.get(st).add(s);
            }
        }

        List<List<String>> final_list=new ArrayList<>();

        for(Map.Entry<String,List<String>> entry:map.entrySet())
        {
            final_list.add(entry.getValue());
        }

        return final_list;
    }
}