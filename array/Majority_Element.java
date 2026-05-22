class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int val = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]==val){
                cnt++;
            }
            else{
                cnt--;
            }
            if(cnt<=0){
                cnt=1;
                val=nums[i];
            }
        }
        return val;
    }

    public int majorityElement1(int[] nums) {
        int ans = nums[0];
        int cnt = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==ans){
                cnt++;
            }
            else{
                cnt--;
            }
            if(cnt<0){
                ans= nums[i];
                cnt=1;
            }
        }
        return ans;
    }
}