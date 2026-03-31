import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Map<Integer , Integer>mp = new HashMap<>();
        int []ans = new int[2];
        int sumC =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mp.containsKey(grid[i][j])){
                    ans[0]=grid[i][j];
                }
                mp.put(grid[i][j],1);
                sumC+=grid[i][j];
            }
        }
        n=n*n;
        sumC-=ans[0];
        int sum = (n*(n+1))/2;
        ans[1] = Math.abs(sumC-sum);
        return ans;
    }
}
