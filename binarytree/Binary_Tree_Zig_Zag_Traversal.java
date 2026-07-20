class Binary_Tree_Zig_Zag_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 1));
        List<Integer> arr = new ArrayList<>();
        int currLev = 1;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> front = q.poll();
            if (front.getValue() != currLev) {
                if (currLev % 2 == 0) {
                    Collections.reverse(arr);
                }
                currLev++;
                ans.add(arr);
                arr = new ArrayList<>();
                // System.out.println(arr.toString() +"V "+ ans.toString());
            }

            TreeNode node = front.getKey();
            arr.add(node.val);
            System.out.println(node.val);

            if (node.left != null) {
                q.add(new Pair<>(node.left, front.getValue() + 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, front.getValue() + 1));
            }
        }
        if (arr.size() != 0) {
            if (currLev % 2 == 0) {
                Collections.reverse(arr);
            }
            ans.add(arr);
        }
        return ans;

    }
}