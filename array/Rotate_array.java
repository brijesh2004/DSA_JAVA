class Rotate_array {
   private void rotateList(int [] nums , int st , int end){
        while(end>st){
            // swap
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k%n;
        k = n-k;
        rotateList(nums , 0 ,k-1);
        rotateList(nums , k , n-1);
        rotateList(nums , 0 , n-1);
    }
}