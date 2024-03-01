class Solution {
    public String maximumOddBinaryNumber(String s) 
    {
        int[] count_arr=new int[2];

        count_arr[0]=0;
        count_arr[1]=0;

        int len=s.length();

        for(int i=0;i<len;i++)
        {
            char c=s.charAt(i);

            if(c=='0')
            {
                count_arr[0]++;
            }else{
                count_arr[1]++;
            }
        }

        System.out.print("0->"+count_arr[0]+" 1-> "+count_arr[1]);

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<count_arr[1]-1;i++)
        {
            sb.append('1');
        }
        for(int i=0;i<count_arr[0];i++)
        {
            sb.append('0');
        }

        sb.append('1');

        return sb.toString();        
       
    }
}