
class Pair<K, V> {
    private K key;
    private V val;

    public Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.val;
    }
}

class Evaluate_Division {

    // U->V
    private double dfs(String u, String v, Map<String, List<Pair<String, Double>>> adj, Map<String, Boolean> visited) {
        if (!adj.containsKey(u))
            return -1.0;
        visited.put(u, true);
        for (Pair<String, Double> nei : adj.get(u)) {
            if (nei.getKey().equals(v))
                return nei.getValue();

            if (!visited.containsKey(nei.getKey()) || !visited.get(nei.getKey())) {

                double val = dfs(nei.getKey(), v, adj, visited);
                if (val != -1.0) {
                    return nei.getValue() * val;
                }
            }
        }
        // visited.put(u, false);
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String, Double>>> adj = new HashMap<>();
        Map<String, Boolean> isPresent = new HashMap<>();

        // create graph
        for (int i = 0; i < eq.size(); i++) {
            List<String> kt = eq.get(i);
            String u = kt.get(0);
            String v = kt.get(1);
            double val = values[i];

            isPresent.put(u, true);
            isPresent.put(v, true);

            if (!adj.containsKey(u)) {
                List<Pair<String, Double>> pt = new ArrayList<>();
                adj.put(u, pt);
            }
            adj.get(u).add(new Pair<>(v, val));

            if (!adj.containsKey(v)) {
                List<Pair<String, Double>> pt = new ArrayList<>();
                adj.put(v, pt);
            }
            adj.get(v).add(new Pair<>(u, 1 * 1.0 / val));
        }

        int n = queries.size();

        double[] ans = new double[n];

        for (int i = 0; i < n; i++) {
            List<String> kt = queries.get(i);
            String u = kt.get(0);
            String v = kt.get(1);
            Map<String, Boolean> visited = new HashMap<>();

            if (isPresent.containsKey(u) && isPresent.containsKey(v)) {
                // System.out.println("U: "+ u + " V: "+v);
                if (u.equals(v)) {
                    ans[i] = 1.00000;
                } else {
                    ans[i] = dfs(u, v, adj, visited);
                }
            } else {
                ans[i] = -1.00000;
            }

        }

        return ans;
    }
}