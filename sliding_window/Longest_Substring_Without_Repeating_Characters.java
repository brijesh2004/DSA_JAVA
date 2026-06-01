package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int last = 0;
        Map<Character , Integer> cnt = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
            while(cnt.get(ch)>1){
                char ch1 = s.charAt(last);
                cnt.put(ch1 , cnt.get(ch1)-1);
                if(cnt.get(ch1)==0){
                    cnt.remove(ch1);
                }
                last++;
            }
            ans = Math.max(ans ,i-last+1);
        }
        return ans;
    }
}
