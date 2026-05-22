package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

public class Vertical_Traversal_of_Tree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        // column -> level -> list of nodes
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

        Queue<Pair<TreeNode, Pair<Integer, Integer>>> q = new LinkedList<>();

        // node , (level , column)
        q.add(new Pair<>(root, new Pair<>(0, 0)));

        while (!q.isEmpty()) {

            Pair<TreeNode, Pair<Integer, Integer>> front = q.poll();

            TreeNode node = front.getKey();

            int level = front.getValue().getKey();
            int col = front.getValue().getValue();

            map.putIfAbsent(col, new TreeMap<>());

            map.get(col).putIfAbsent(level, new ArrayList<>());

            map.get(col).get(level).add(node.val);

            if (node.left != null) {
                q.add(new Pair<>(node.left, new Pair<>(level + 1, col - 1)));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, new Pair<>(level + 1, col + 1)));
            }
        }

        for (int col : map.keySet()) {

            List<Integer> temp = new ArrayList<>();

            for (int level : map.get(col).keySet()) {

                List<Integer> nodes = map.get(col).get(level);

                Collections.sort(nodes);

                temp.addAll(nodes);
            }

            ans.add(temp);
        }

        return ans;

    }
}
