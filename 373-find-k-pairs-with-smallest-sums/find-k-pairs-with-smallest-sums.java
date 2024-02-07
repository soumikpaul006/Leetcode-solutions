class Solution
{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums1.length; i++)
        {
            for (int j = 0; j < nums2.length; j++)
            {

                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.offer(new Pair(sum, i, j));
                } else if (pq.peek().sum > sum) {
                    pq.poll();
                    pq.offer(new Pair(sum, i, j));
                } else {
                    break;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Pair pair = pq.peek(); 
            pq.remove();

            int x = nums1[pair.index1];
            int y = nums2[pair.index2];

            list.add(x);
            list.add(y);

            result.add(list);
        }

        return result;
    }

    class Pair implements Comparable<Pair>
    {
        int sum;
        int index1;
        int index2;

        public Pair(int sum, int index1, int index2) 
        {
            this.sum = sum;
            this.index1 = index1;
            this.index2 = index2;
        }

        public int compareTo(Pair other) 
        {
            return Integer.compare(this.sum, other.sum);
        }
    }
}