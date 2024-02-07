class Solution {
    public String reorganizeString(String s)
    {
        HashMap<Character,Integer> map=new HashMap<>(); 
        int len=s.length(); 

        // Count the frequency of each character
        for(int i=0;i<s.length();i++)   
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        // Create a max heap based on character frequencies
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());

        // Determine the maximum frequency of a character
        int max_ele=Integer.MIN_VALUE;
        for(int num:map.values())
        {
            max_ele=Math.max(max_ele,num);
        }

        // If the maximum frequency is greater than half the length + 1, it's impossible to rearrange
        if(max_ele>(len+1)/2)
        {
            //invalid
            return "";
        }

        // Fill the even positions with characters with higher frequency
        StringBuilder sb=new StringBuilder(len);

        while(!pq.isEmpty())
        {
            char ch=pq.remove();
            int fre=map.get(ch);

            while(fre>0)
            {
                sb.append(ch);
                fre--;
            }
        }

        // Interleave the characters starting from index 1
        char[] ans=new char[len];
        int idx=0;
        for(int i=0;i<len;i+=2)
        {
            ans[i]=sb.charAt(idx++);
        }

        for(int i=1;i<len;i+=2)
        {
            ans[i]=sb.charAt(idx++);
        }

        return new String(ans);
    }
}
