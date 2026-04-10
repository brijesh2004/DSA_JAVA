package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.w3c.dom.Node;

public class bottomView {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Map<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {

            Pair<Node, Integer> f = q.poll();
            Node front = f.getKey();
            int key = f.getValue();

            mp.put(key, front.data);

            if (front.left != null) {
                q.add(new Pair<>(front.left, key - 1));
            }
            if (front.right != null) {
                q.add(new Pair<>(front.right, key + 1));
            }

        }

        ArrayList<Integer> ans = new ArrayList<>(mp.values());

        return ans;
    }
}
