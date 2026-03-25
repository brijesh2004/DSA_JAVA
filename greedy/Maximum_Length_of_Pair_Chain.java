class Solution {
    public int findLongestChain(int[][] pairs) {
     
    Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

     int ans = 1;
     int prevInd = 0;
     for(int i=0;i<pairs.length;i++){
        if(pairs[i][0]>pairs[prevInd][1]){
            ans++;
            prevInd = i;
        }
     }
     return ans;  
    }
}