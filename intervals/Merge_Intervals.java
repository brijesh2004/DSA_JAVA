public class Merge_Intervals{
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            // Compare first column
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            // If first column is equal, compare second column
            return Integer.compare(a[1], b[1]);
        });

        int k=0;
        int last = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0] , intervals[0][1]});
        int n = intervals.length;
        for(int i=1;i<n;i++){
            int f = intervals[i][0];
            int l = intervals[i][1];

            if(last>=f){
                last = Math.max(last , l);
                list.get(list.size()-1)[1] = last;
            }else{
                list.add(new int[]{f , l});
                last = l;
            }
        }

        int [][] ans = new int[list.size()][];
        int ki = 0;
        for(int [] li: list){
            ans[ki] = li;
            ki++;
        }

        return ans;
    }
}