package hashmap;

import java.util.Arrays;

public class Is_Anagram {
    public boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        String t1 = new String(ch1);
        String t2 = new String(ch2);

        return t1.equals(t2);

    }
}
