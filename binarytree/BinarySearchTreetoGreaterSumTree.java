package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class BinarySearchTreetoGreaterSumTree {
    
    private void inOrder(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }

    

    private TreeNode solve(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);

        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            index.put(arr.get(i), i);
        }

        // calculate sum
        for (int i = arr.size() - 2; i >= 0; i--) {
            int val = arr.get(i) + arr.get(i + 1);
            arr.set(i, val);
        }

        // BFS
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode front = q.poll();
            int val = front.val;
            int ind = index.get(val);
            int sum = arr.get(ind);
            front.val = sum;

            if (front.left != null)
                q.add(front.left);
            if (front.right != null)
                q.add(front.right);
        }
        return root;
    }


    private void postOrder(TreeNode root , int currSum) {
        if (root == null)
            return ;

        postOrder(root.right , currSum);
        currSum += root.val;
        root.val = currSum;
        postOrder(root.left , currSum);
    }

    public TreeNode bstToGst(TreeNode root) {
        // return solve(root);
        postOrder(root , 0);
        return root;
    }
}
