class Solution 
{
    public String removeOccurrences(String s, String part) 
    {
        StringBuilder sb = new StringBuilder(s);
        
        while(sb.indexOf(part) != -1) 
        {
            int start = sb.indexOf(part);
            sb.delete(start, start + part.length());
        }
        
        return sb.toString();
    }
}