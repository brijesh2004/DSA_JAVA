package hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
     public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character , Integer>mp = new HashMap<>();

        for(int i=0;i<magazine.length();i++){
           char ch = magazine.charAt(i);
        //    mp.put(ch , mp.getOrDefault(ch,0)+1);
           mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for(int i=0;i<ransomNote.length();i++){
            char ch1 = ransomNote.charAt(i);
            if(!mp.containsKey(ch1)){
                return false;
            }
           mp.put(ch1 , mp.get(ch1)-1);
           if(mp.get(ch1)==0){
            mp.remove(ch1);
           }
        }
        return true;
    }
}
