public class Gas_Station {
     public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0;
        int cnt = 0;
        int currGas = 0;
        int currCost = 0;
        for(int i=0;i<gas.length;i++){
            currGas += (gas[i]-cost[i]);
            // System.out.println("i -> "+ i + " currG -> "+ currGas);
            if(currGas<0){
                cnt+= currGas;
                currGas = 0;
                ans = i+1;
            }
        }


        //  System.out.println("cnt -> "+ cnt + " currG -> "+ currGas);

        if(currGas+cnt>=0) return ans;
        return -1;
    }
}
