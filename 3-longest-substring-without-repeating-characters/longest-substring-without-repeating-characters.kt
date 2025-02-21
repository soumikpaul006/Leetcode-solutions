class Solution {
    fun lengthOfLongestSubstring(s: String): Int 
    {
        val set=HashSet<Char>()

        var i=0
        var j=0

        var ans=0

        while(j<s.length)
        {
            while(set.contains(s[j]))
            {
                set.remove(s[i])
                i++
            }

            set.add(s[j])
            j++

            ans=max(ans,(j-i))
        }


        return ans
    }
}