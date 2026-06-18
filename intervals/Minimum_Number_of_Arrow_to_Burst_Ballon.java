public class Minimum_Number_of_Arrow_to_Burst_Ballon {
       public int findMinArrowShots(int[][] points) {
        int ans = 1;
        Arrays.sort(points, (a, b) -> {
            // Compare first column
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            // If first column is equal, compare second column
            return Integer.compare(a[1], b[1]);
        });
        int max = points[0][1];
        int n = points.length;
        for(int i=1;i<n;i++){
            int val = points[i][0];
            if(val>max){
                ans++;
                max = points[i][1];
            }else{
                max = Math.min(max , points[i][1]);
            }
        }
        return ans;
    }
}