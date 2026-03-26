class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int currA = capacityA;
        int currB = capacityB;
        int st = 0;
        int end = plants.length-1;

        while(st<end){
            if(currA<plants[st]){
                ans++;
                currA=capacityA;
            }
            if(currB<plants[end]){
                ans++;
                currB = capacityB;
            }


            currA-=plants[st];
            currB-=plants[end];
            st++;
            end--;
        }

        if(st==end){
            if(currA>=plants[st]){

            }else if(currB>=plants[end]){

            }else{
                ans++;
            }
        }
        return ans;
    }
}