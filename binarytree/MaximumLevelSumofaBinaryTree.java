package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 1));
        int level = 1;
        int maxSum = root.val;
        int currLevel = 1;
        int currSum = 0;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> front = q.poll();
            int lev = front.getValue();
            // System.out.println("Sum " + lev + " CurrSUm "+ currSum);
            if (lev != currLevel) {
                if (currSum > maxSum) {
                    maxSum = currSum;
                    level = currLevel;
                }
                currSum = 0;
                currLevel++;
            }

            TreeNode f = front.getKey();
            currSum += f.val;
            if (f.left != null) {
                q.add(new Pair<>(f.left, lev + 1));
            }
            if (f.right != null) {
                q.add(new Pair<>(f.right, lev + 1));
            }
        }

        if (currSum > maxSum) {
            maxSum = currSum;
            level = currLevel;
        }

        return level;
    }
}
