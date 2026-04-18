import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}


public class MaximumWidthofBinaryTree {
     public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

    int maxWidth = 0;

    Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
    q.add(new Pair<>(root, 0L));

    while (!q.isEmpty()) {
        int size = q.size();
        long minIndex = q.peek().getValue(); // normalize index
        long first = 0, last = 0;

        for (int i = 0; i < size; i++) {
            Pair<TreeNode, Long> p = q.poll();
            TreeNode node = p.getKey();
            long index = p.getValue() - minIndex;

            if (i == 0) first = index;
            if (i == size - 1) last = index;

            if (node.left != null) {
                q.add(new Pair<>(node.left, index * 2));
            }
            if (node.right != null) {
                q.add(new Pair<>(node.right, index * 2 + 1));
            }
        }

        maxWidth = Math.max(maxWidth, (int)(last - first + 1));
    }

    return maxWidth;
    }
}
