public class Summary_Ranges {
     public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length==0) return ans;
        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            if (i!=nums.length && nums[i] == nums[i-1]+1) {
                
            } else {
                if(nums[i-1]!=start){
                    String r = start+"->"+nums[i-1];
                    ans.add(r);
                }else{
                    ans.add(String.valueOf(start));
                }
                if(i!=nums.length)
                  start = nums[i];
            }
        }
        return ans;



    }
}