class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int start_r=0;
        int end_r=matrix.length-1;

        while(start_r<=end_r)
        {
            int mid=(start_r+end_r)/2;

            if(matrix[mid][0]==target)
            {
                return true;
            }
            else if(target>matrix[mid][0])
            {
                start_r=mid+1;
            }
            else{
                end_r=mid-1;
            }
        }


        // end_r may be -1, start_r should be in bounds
        int row=end_r>=0?end_r:0;

        // if (end_r == -1 || row >= matrix.length) 
        // {
        //     return false;
        // }

        int[] selectedRow=matrix[row];

        int start=0;
        int end=selectedRow.length-1;

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(selectedRow[mid]==target)
            {
                return true;
            }
            if(target>selectedRow[mid])
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return false;

    }
}