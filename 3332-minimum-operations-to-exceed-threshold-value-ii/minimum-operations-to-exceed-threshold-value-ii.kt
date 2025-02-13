class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {

        var pq=PriorityQueue<Long>()

        for(num in nums)
        {
            pq.add(num.toLong())
        }

        var count=0

        while(pq.size>=2 && pq.peek()<k)
        {
            val x=pq.remove()
            val y=pq.remove()

            pq.add(x*2+y)

            count++
        }

        return count
        
    }
}