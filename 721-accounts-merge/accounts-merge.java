class Solution 
{
    class DisjointSet
    {
        List<Integer> parent=new ArrayList<>();
        List<Integer> size=new ArrayList<>();

        public DisjointSet(int n)
        {
            for(int i=0;i<n;i++)
            {
                parent.add(i);
                size.add(1);
            }
        }

        public int find(int node)
        {
            while(parent.get(node)!=node)
            {
                int root=find(parent.get(node));
                parent.set(node,root);
                return parent.get(node);
            }
            return node;
        }

        public void unionBySize(int u,int v)
        {
            int iRoot=find(u);
            int jRoot=find(v);

            if(iRoot==jRoot) return;

            if(size.get(iRoot)<size.get(jRoot))
            {
                parent.set(iRoot,jRoot);
                size.set(jRoot,size.get(iRoot)+size.get(jRoot));
            }
            else{
                parent.set(jRoot,iRoot);
                size.set(iRoot,size.get(iRoot)+size.get(jRoot));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) 
    {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);

        HashMap<String,Integer> emailToIndex_map=new HashMap<>();

        //STEP 1
        //Map the emails to their index and 
        //If any email is already mapped to the index the union the current index with the already present index
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String email=accounts.get(i).get(j);
                if(!emailToIndex_map.containsKey(email))
                {
                    emailToIndex_map.put(email,i);
                }
                else{
                    ds.unionBySize(i,emailToIndex_map.get(email));
                }
            }
        } 

        //STEP 2
        // assign all the email to their ultimate parent 
        ArrayList<ArrayList<String>> mergeEmail = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            mergeEmail.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> map : emailToIndex_map.entrySet()) 
        {
            String email = map.getKey();
            mergeEmail.get(ds.find(map.getValue())).add(email);
        }

        //STEP 3
        //CREATE A List of Name along with their child emails

        List<List<String>> ans_list=new ArrayList<>();

       
        for(int i=0;i<n;i++)
        {
            if (mergeEmail.get(i).isEmpty()) {
                continue;
            }

            Collections.sort(mergeEmail.get(i));

            List<String> temp_list=new ArrayList<>();

            temp_list.add(accounts.get(i).get(0));  //Add the name first;

            for(String s:mergeEmail.get(i))
            {
                temp_list.add(s);
            }
            ans_list.add(temp_list);
        }

        return ans_list;

    }
}