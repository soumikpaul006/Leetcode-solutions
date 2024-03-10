class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    {   
        if(nums1.length>nums2.length) return intersection(nums2,nums1);

        Arrays.sort(nums2);

        Set<Integer> set=new HashSet<>();

        for(int i=0;i<nums1.length;i++)
        {
            set.add(nums1[i]);
        }

        List<Integer> list=new ArrayList<>();

        for(int num:set)
        {
            int ans=binarySearch(nums2,num);

            if(ans!=-1)
            {
                list.add(nums2[ans]);
            }
        }

        int[] arr=new int[list.size()];

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=list.get(i);
        }

        return arr;
    
    }
    public int binarySearch(int[] arr,int target)
    {
        int i=0;
        int j=arr.length-1;

        while(i<=j)
        {
            int mid=(i+j)/2;

            if(arr[mid]==target) return mid;

            else if(arr[mid]>target)
            {
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return -1;
    }
}