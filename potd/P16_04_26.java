package potd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P16_04_26 {
    
    private List<Integer> solve(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();

        // Step 2: Process each query
        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            // If only one occurrence → no answer
            if (list.size() == 1) {
                res.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(list, q);

            int prev = (idx - 1 + list.size()) % list.size();
            int next = (idx + 1) % list.size();

            int prevIndex = list.get(prev);
            int nextIndex = list.get(next);

            int dist1 = Math.abs(q - prevIndex);
            int dist2 = Math.abs(q - nextIndex);

            // circular distance
            dist1 = Math.min(dist1, n - dist1);
            dist2 = Math.min(dist2, n - dist2);

            res.add(Math.min(dist1, dist2));
        }

        return res;
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> res = new ArrayList<>();
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = Integer.MAX_VALUE;
        }

        Map<Integer, List<Integer>> index = new HashMap<>();

        // store indices of each value
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (index.containsKey(val)) {
                index.get(val).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                index.put(val, list);
            }
        }

        int n = nums.length;

        for (int i = 0; i < queries.length; i++) {
            int currIndex = queries[i];
            int val = nums[currIndex];

            if (index.containsKey(val)) {
                for (Integer ind : index.get(val)) {
                    if (ind == currIndex)
                        continue;

                    int dist;
                    if (ind >= currIndex) {
                        int val1 = ind - currIndex;
                        int val2 = currIndex + n - ind;
                        dist = Math.min(val1, val2);
                    } else {
                        int val1 = currIndex - ind;
                        int val2 = n - currIndex + ind;
                        dist = Math.min(val1, val2);
                    }

                    ans[i] = Math.min(ans[i], dist);
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != Integer.MAX_VALUE) {
                res.add(ans[i]);
            } else {
                res.add(-1);
            }
        }

        return res;
    }
}
