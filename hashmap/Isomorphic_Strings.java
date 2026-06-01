package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character>mp = new HashMap<>();
        Map<Character,Character>mpTo = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch1 =  s.charAt(i);
            char ch2 = t.charAt(i);

            if(mp.containsKey(ch1)){
               if(mp.get(ch1)!=ch2) return false;
               if(mpTo.containsKey(ch2) && mpTo.get(ch2)!=ch1) return false;
            }
            else if(mpTo.containsKey(ch2)){
                 if(mpTo.get(ch2)!=ch1) return false;
            } 
            else{
                mp.put(ch1 , ch2);
                mpTo.put(ch2 , ch1);
            }
        }
        return true;
    }
}
