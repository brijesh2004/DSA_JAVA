package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagram {
     public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>ans = new ArrayList<>();
        Map<String , List<String>>mp = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            char [] ch = str.toCharArray();
            Arrays.sort(ch);

            String key = new String(ch);
           
            if(mp.containsKey(key)){
                mp.get(key).add(str);
            }else{
                List<String> r =new ArrayList<>();
                r.add(str);
                mp.put(key , r);
            }
        }

        for(List<String> st : mp.values()){
            ans.add(st);
        }
        return ans;
    }
}
