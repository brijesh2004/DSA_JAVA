public class jumpgame {
     public boolean canJump(int[] nums) {
        // if(nums[0]<=0) return false;
        int currMaxJump = 0;
        for(int i=0;i<nums.length;i++){
            if(i>currMaxJump) return false;

            currMaxJump = Math.max(currMaxJump,i+nums[i]);
        }
        return currMaxJump>=nums.length-1;
    }
}
