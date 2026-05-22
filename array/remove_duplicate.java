public class remove_duplicate {
    public int removeDuplicates(int[] nums) {
        int i=0,j=1;
        int n = nums.length;
        while(j<n){
            if(nums[i]!=nums[j]){
                // swap
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            j++;
        }
        return i+1;
    }
}
