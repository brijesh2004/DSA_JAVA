package graph;

public class Center_of_star_graph {
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];

        int key = edges[1][0];
        int val = edges[1][1];

        if(a==key || a==val) return a;
        return b;

    }
}
