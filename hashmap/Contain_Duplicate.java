package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Contain_Duplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer>mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(mp.containsKey(val)){
                int ind = mp.get(val);
                if(k>=(i-ind)) return true;
            }
            mp.put(val , i);
        }
        return false;
    }
}
