package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class undirected_cycle_graph {

    private boolean isCyclePresentBFS(int src, List<List<Integer>> adj, boolean[] vis) {

        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        parent.put(src, -1);
        vis[src] = true;

        while (!q.isEmpty()) {
            int front = q.poll();

            for (int nei : adj.get(front)) {
                if (vis[nei] && nei != parent.get(front)) {
                    return true;
                } else if (!vis[nei]) {
                    vis[nei] = true;
                    q.add(nei);
                    parent.put(nei, front);
                }
            }

        }
        return false;

    }

    private boolean isCyclePresentDFS(int src, List<List<Integer>> adj, boolean[] vis, int parent) {

        vis[src] = true;

        for (int nei : adj.get(src)) {
            if (!vis[nei]) {
                if (isCyclePresentDFS(nei, adj, vis, src))
                    return true;
            } else if (nei != parent)
                return true;
        }
        return false;

    }

    public boolean isCycle(int V, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclePresentDFS(i, adj, visited, -1))
                    return true;
            }
        }

        return false;
    }
}
