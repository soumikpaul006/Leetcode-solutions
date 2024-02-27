/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution 
{
    int sum=0;
    public int getImportance(List<Employee> employees, int id) 
    {   
        HashMap<Integer,Employee> map=new HashMap<>();
        // int sum=0;
        
        //mapping emp id with its imp
        for(Employee e:employees)
        {
            map.put(e.id,e);
        }

        return dfs(id,map);
    }
    public int dfs(int id,HashMap<Integer,Employee> map)
    {
        Employee e=map.get(id);
        int imp=e.importance;

        for(int i:e.subordinates)
        {
            imp+=dfs(i,map);
        }

        return imp;

    }
}