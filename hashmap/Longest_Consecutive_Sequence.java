package hashmap;

import java.util.Map;
import java.util.TreeMap;

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer>mp = new TreeMap<>();

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i] , i);
        }
        Integer min = null;
        int max = 0;
        int len = 0;
        for(int key:mp.keySet()){
            if(min==null){
                min = key;
                len= 1;
            }
            if((min+1)==key){
                min = key;
                len++;
            }
            else{
                min = key;
                len = 1;
            }
            max = Math.max(max , len);
        }
        return max;
    }
}
