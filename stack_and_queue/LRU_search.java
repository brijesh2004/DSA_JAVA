package stack_and_queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU_search {
    private Map<Integer, Integer> mp;
    private Deque<Integer> dq;
    int size = 0;

    public LRU_search(int capacity) {
        size = capacity;
        mp = new HashMap<>();
        dq = new LinkedList<>();
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }
        

        dq.remove(key);
        dq.addFirst(key);
        return mp.get(key);
    }

    public void put(int key, int value) {

        if (mp.containsKey(key)) {
            dq.remove(key);
            dq.addFirst(key);
            mp.put(key, value);
            return;
        }
        if (dq.size() == size) {
            int keyRem = dq.removeLast();
            mp.remove(keyRem);
        }
        dq.addFirst(key);
        mp.put(key, value);

    }
}
