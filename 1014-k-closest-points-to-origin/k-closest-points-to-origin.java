class Solution {
    public int[][] kClosest(int[][] points, int k)
    {
        // store the points as per the lowest distance, ensuring that the point with the smaller distance is given higher priority.
        PriorityQueue<int[]> pq=new PriorityQueue<>(k,(arr1,arr2)->Integer.compare(distance(arr2),distance(arr1)));

        for(int[] point:points)
        {
            pq.add(point);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.toArray(new int[0][0]);//coverts the pq into 2D array and returns it.
    }
    public int distance(int[] arr)
    {
        return (arr[0]*arr[0]+arr[1]*arr[1]);
    }
}