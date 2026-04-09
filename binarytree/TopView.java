package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.w3c.dom.Node;

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class TopView {
    public ArrayList<Integer> topView(Node root) {
        // code here
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> temp = q.poll();
            Node node = temp.getKey();
            int hd = temp.getValue();

            // First node at this horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                q.add(new Pair<>(node.left, hd - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, hd + 1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(map.values());
        return ans;

    }
}
