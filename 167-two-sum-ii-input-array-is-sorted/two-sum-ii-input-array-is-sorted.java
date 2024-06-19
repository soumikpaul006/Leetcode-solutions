class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        int[] arr=new int[2];
        Arrays.fill(arr,-1);

        int start=0;
        int end=numbers.length-1;

        while(start<end)
        {
            // int mid=(start+end)/2;

            if(numbers[start]+numbers[end]==target)
            {
                arr[0]=start+1;
                arr[1]=end+1;
                break;
            }
            else if(numbers[start]+numbers[end]<target)
            {
                start=start+1;
            }
            else{
                end=end-1;
            }

        }

        return arr;   
    }
}