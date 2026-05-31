package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int st = i + 1;
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int end = nums.length - 1;
            while (end > st) {
                int sum = nums[i] + nums[st] + nums[end];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[st], nums[end]));
                    st++;
                    end--;
                    
                    while (st < end && nums[st] == nums[st - 1])
                        st++;

                    while (st < end && nums[end] == nums[end + 1])
                        end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    st++;
                }
            }
        }

        return ans;

    }
}
