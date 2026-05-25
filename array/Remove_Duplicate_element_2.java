public class Remove_Duplicate_element_2 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        for(int j=0;j<n;j++){
            if(i<2 || nums[i-2]!=nums[j]){
               nums[i] = nums[j];
               i++;
            }
        }
    
        return i;
    }

}
