class Solution 
{
    fun lengthOfLongestSubstring(s: String): Int 
    {
        val map=mutableMapOf<Char,Int>()

        var i=0
        var ans=0

        for(j in s.indices)
        {
            val ch=s[j]

            if(map.containsKey(ch) && map[ch]!!>=i)
            {
                i = map[ch]!!+1
            }

            map[ch]=j

            ans=max(ans,j-i+1)

        }

        return ans
    }
}