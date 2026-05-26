public class Jump_game_2 {
    private int nextStart(int [] nums , int st ){
        int val = nums[st];
        int n = nums.length;
        int max = val;
        int nextIndex = st;
        for(int i=st+1;i<val+st+1 && i<nums.length ;i++){
            int maxGo = nums[i]+i;
            if(maxGo>=max){
                max = maxGo;
                nextIndex = i;
            }
            if(i==n-1) return n;
        }
        return nextIndex;
    }
    public int jump(int[] nums) {
        int start = 0;
        int ans = 0;
        int n = nums.length;

        while(start<n){
            if(start>=n-1) return ans;
            int nextIndex = nextStart(nums ,start);
            System.out.println("next : " + nextIndex);
            ans++;
            start = nextIndex;
        }
        return ans;


    }
}
