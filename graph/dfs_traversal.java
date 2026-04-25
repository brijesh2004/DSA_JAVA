package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class dfs_traversal {
      private void dfsTraversal(int val ,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer>ans, Map<Integer,Boolean>vis)
{
    vis.put(val , true);
    ans.add(val);
    
    for(int v: adj.get(val)){
        if(!vis.containsKey(v)){
            dfsTraversal(v , adj , ans, vis);
        }
    }
}    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        ArrayList<Integer>ans = new ArrayList<>();
        Map<Integer,Boolean>vis = new HashMap<>();
        dfsTraversal(0 , adj , ans , vis);
        return ans;
        
        
        
    }
}
