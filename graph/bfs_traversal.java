package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class bfs_traversal {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Map<Integer,Boolean>vis = new HashMap<>();
        
        
        while(!q.isEmpty()){
           int front = q.poll();
           vis.put(front , true);
           ans.add(front);
           for(int val : adj.get(front)){
               if(!vis.containsKey(val)){
                   q.add(val);
                   vis.put(val , true);
               }
           }
        }
        return ans;
    }
}
