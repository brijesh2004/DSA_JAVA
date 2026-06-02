package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer>mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                return new int[]{mp.get(nums[i]) , i}; 
            }
            int key = target-nums[i];
            mp.put(key , i);
        }
        return new int[]{-1 , -1};
    }
}
