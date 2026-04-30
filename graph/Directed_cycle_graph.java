package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directed_cycle_graph {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Map<Integer , List<Integer>>adj = new HashMap<>();
        
        for(int i=0;i<edges.length;i++){
            int key = edges[i][0];
            int val = edges[i][1];
           // If key is absent, create a new ArrayList, then add the value
         adj.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        
        boolean [] vis = new boolean[V];
        boolean [] nodevis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(bfs(i , adj , vis , nodevis)) return true;
            }
        }
        return false;
        
    }
    
    private boolean dfs(int node , Map<Integer,List<Integer>>adj , boolean []vis ,boolean []nodevis){
        vis[node]=true;
        nodevis[node]=true;
        
        if(adj.get(node)!=null){
            
        for(int key : adj.get(node)){
            if(!vis[key]){
                boolean cycle = dfs(key ,adj , vis , nodevis);
                if(cycle) return true;
            }else if(nodevis[key]){
                return true;
            }
        }
        }
        nodevis[node] = false;
        return false;
    }
}
