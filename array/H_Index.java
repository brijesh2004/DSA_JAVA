import java.util.Arrays;

public class H_Index {
     private boolean isValid(int[] cit, int mid) {
        int n = cit.length;

        // check if there are at least mid papers
        // having citations >= mid
        return cit[n - mid] >= mid;
    }

    public int hIndex(int[] cit) {

        Arrays.sort(cit);

        int start = 0;
        int end = cit.length;
        int ans = 0;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // mid = possible h-index
            if (mid == 0 || isValid(cit, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
