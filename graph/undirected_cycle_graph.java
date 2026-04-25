package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class undirected_cycle_graph {
    private boolean isCyclePresent(int src, List<List<Integer>> adj, boolean[] visited) {

    Queue<Integer> q = new LinkedList<>();
    Map<Integer, Integer> parent = new HashMap<>();

    q.add(src);
    visited[src] = true;
    parent.put(src, -1);

    while (!q.isEmpty()) {
        int node = q.poll();

        for (int nei : adj.get(node)) {
            if (visited[nei] && parent.get(node) != nei) {
                return true;
            }
            if (!visited[nei]) {
                visited[nei] = true;
                parent.put(nei, node);
                q.add(nei);
            }
        }
    }

    return false;
}

public boolean isCycle(int V, int[][] edges) {

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

    for (int[] e : edges) {
        int u = e[0];
        int v = e[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            if (isCyclePresent(i, adj, visited)) return true;
        }
    }

    return false;
}
}
