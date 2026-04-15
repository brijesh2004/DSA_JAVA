package potd;

public class P15_04_26 {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        int n = words.length;
        for(int i=0;i<n;i++){
            String word = words[i];
            if(word.equals(target)){
                
                if(i>=startIndex){
                    int val1 = i-startIndex;
                    int val2 = startIndex+n-i;
                    ans = Math.min(ans , Math.min(val1 , val2));
                }
                else{
                    int val1 = startIndex-i;
                    int val2 = n-startIndex+i;
                    ans = Math.min(ans , Math.min(val1 , val2));
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
