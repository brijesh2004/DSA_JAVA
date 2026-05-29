import java.util.HashMap;
import java.util.Map;

public class Zigzag {
    Map<Integer, String> mp = new HashMap<>();
        boolean isIncreasing = true;
        int k = -1;
        for (int i = 0; i < s.length(); i++) {
            if (isIncreasing && k == numRows-1) {
                isIncreasing = false;
            } else if (!isIncreasing && k == 0) {
                isIncreasing = true;
            }
            k = isIncreasing ? k + 1 : k - 1;
            System.out.println("k -> "+ k + " i-> "+ i);

            if (mp.containsKey(k)) {
                String st = mp.get(k);
                st += s.charAt(i);
                mp.put(k, st);
            } else {
                String st = "";
                st += s.charAt(i);
                mp.put(k, st);
            }
        }

        String ans = "";
        for (int st : mp.keySet()) {
            System.out.println("st-> " + st);
            ans += mp.get(st);
        }
        return ans;
    }
}
