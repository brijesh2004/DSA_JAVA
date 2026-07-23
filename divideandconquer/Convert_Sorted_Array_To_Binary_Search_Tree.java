class Convert_Sorted_Array_To_Binary_Search_Tree {
    private TreeNode solve(int s , int e , int []nums){
        if(s>e) return null;
        int mid = (s+e)/2;
        TreeNode root =new TreeNode(nums[mid]);

        root.left = solve(s , mid-1 , nums);
        root.right = solve(mid+1 , e , nums);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(0 , nums.length-1 , nums);
    }
}