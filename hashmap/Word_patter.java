package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Word_patter {
   public boolean wordPattern(String pattern, String s) {
        String[] sp = s.split(" ");
        Map<Character, String> mp = new HashMap<>();
        Map<String, Character> mpTo = new HashMap<>();
        if(pattern.length()!=sp.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String st = sp[i];
            if (mp.containsKey(ch)) {
                if (!mp.get(ch).equals(st))
                    return false;
                if (mpTo.containsKey(st) && mpTo.get(st) != ch)
                    return false;
            } else if (mpTo.containsKey(st)) {
                if (mpTo.get(st) != ch)
                    return false;
            } else {
                mp.put(ch, st);
                mpTo.put(st, ch);
            }
        }

        return true;

    }
}
