class Solution {
    fun maximumSum(nums: IntArray): Int {

        var ans=-1

        var arr=Array(82){-1}


        for(num in nums)
        {
            val digit_sum=digitSum(num)

            if(arr[digit_sum]!=-1)
            {
                ans=max(ans,num+arr[digit_sum])
            }

            arr[digit_sum]=max(arr[digit_sum],num)
        }

        return ans
        
    }
    fun digitSum(num:Int):Int{

        var sum=0
        var n=num

        while(n>0)
        {
            sum+=n%10
            n/=10
        }

        return sum
    }
}