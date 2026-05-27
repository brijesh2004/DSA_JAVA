import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Insert_Delete_Random {
    Map<Integer, Integer> mp;
    List<Integer> list;
    Random random;

    public Insert_Delete_Random() {
        mp = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (mp.containsKey(val))
            return false;

        list.add(val);
        mp.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!mp.containsKey(val))
            return false;

        int remIndex = mp.get(val);
        int lastVal = list.get(list.size() - 1);

        // Move last element to removed index
        list.set(remIndex, lastVal);

        // Update hashmap
        mp.put(lastVal, remIndex);

        // Remove last element
        list.remove(list.size() - 1);

        // Remove val from map
        mp.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
