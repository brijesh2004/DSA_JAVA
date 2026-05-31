package two_pointer;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int st = 0;
        int end = height.length-1;
        int ans = 0;

        while(end>st){
            int area = (end-st) *Math.min(height[st] , height[end]);
            ans = Math.max(area , ans);
            if(height[st]>height[end]){
                end--;
            }
            else{
                st++;
            }
        }
        return ans;
    }
}
