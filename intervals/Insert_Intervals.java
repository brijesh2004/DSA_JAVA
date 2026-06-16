public class Insert_Intervals{
     public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }





public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] ans = new int[n + 1][];

        int start = newInterval[0];
        int end = newInterval[1];
        int k = 0;

        for (int i = 0; i < n; i++) {
            int st = intervals[i][0];
            int ed = intervals[i][1];

            if (end != -1) {
                // insert at first
                if (end < st) {
                    ans[k] = new int[] { start, end };
                    end = -1;
                    start = -1;
                    k++;
                    ans[k] = new int[] { st, ed };
                } else if (start >= st && start <= ed) {
                    // insert in middle
                    ans[k] = new int[] { st, Math.max(end, ed) };
                    end = -1;
                    start = -1;
                }
                else if(st<=end&&st>=start){
                     ans[k] = new int[] { Math.min(st , start), Math.max(end, ed) };
                    end = -1;
                    start = -1;
                }
                else{
                    ans[k] = new int[] { st, ed };
                }
            } else {
                if (k > 0) {
                    if (ans[k - 1][1] >= st) {
                        ans[k - 1] = new int[] { ans[k - 1][0], Math.max(ans[k - 1][1], ed) };
                        k--;
                    } else {
                        ans[k] = new int[] { st, ed };
                    }
                } else {
                    ans[k] = new int[] { st, ed };
                }

            }
            k++;
        }

        // insert at last
        if (end != -1) {
            ans[k] = new int[] { start, end };
            k++;
        }
        

        int [][] res = new int[k][];

        for(int i=0;i<k;i++){
            res[i] = ans[i];
        }

        return res;
    }


}