class Course_Selection {

    private boolean dfs(int node, Map<Integer, List<Integer>> adj,

            boolean[] vis, boolean[] pathVis) {

        vis[node] = true;

        pathVis[node] = true;

        if (adj.get(node) != null) {

            for (int nei : adj.get(node)) {

                if (!vis[nei]) {

                    if (dfs(nei, adj, vis, pathVis))

                        return true;

                } else if (pathVis[nei]) {

                    return true; // cycle

                }

            }

        }

        pathVis[node] = false;

        return false;

    }

    public boolean canFinish(int num, int[][] pre) {

        Map<Integer, List<Integer>> adj = new HashMap<>();

       


        for (int[] p : pre) {

            adj.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);

    

        }

        boolean[] vis = new boolean[num];

        boolean[] pathVis = new boolean[num];


        for (int i = 0; i < num; i++) {

            if (!vis[i]) {

                if (dfs(i, adj, vis, pathVis)) {

                    return false; // cycle found

                }

            }

        }


        return true;
    }
}