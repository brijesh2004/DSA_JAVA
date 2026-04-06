public class Single_Number {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for(var a:nums){
            ans^=a;
        }
        return ans;
    }
}
