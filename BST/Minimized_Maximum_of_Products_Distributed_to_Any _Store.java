class Solution {
   private boolean isPossible(int[] q, int val, int n) {
    int assign = 0;

    for (int i = 0; i < q.length; i++) {
        assign += (q[i] + val - 1) / val; 
    }

    return assign <= n;
}

public int minimizedMaximum(int n, int[] quantities) {
    int st = 1, end = 0;

    for (int q : quantities) {
        end = Math.max(end, q);
    }

    int ans = end;

    while (st <= end) {
        int mid = st + (end - st) / 2;

        if (isPossible(quantities, mid, n)) {
            ans = mid;
            end = mid - 1;
        } else {
            st = mid + 1;
        }
    }

    return ans;
}
}