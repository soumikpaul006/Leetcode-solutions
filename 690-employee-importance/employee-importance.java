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

        HashMap<Integer,Integer> map=new HashMap<>();
        
        //mapping emp id with its imp
        for(Employee e:employees)
        {
            map.put(e.id,e.importance);
        }

        dfs(employees,id,map);
       
        return sum;
    }
    public void dfs(List<Employee> emp, int id,HashMap<Integer,Integer> map)
    {

        for(Employee e : emp)
        {
            if(e.id == id)
            {
                sum += map.get(id);
                List<Integer> subordinates = e.subordinates;
                for(Integer i : subordinates)
                {
                    dfs(emp, i, map); // Recursively calculate importance of subordinates
                }
            }
        }
    }
}