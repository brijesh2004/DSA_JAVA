package two_pointer;

public class Two_Sum_2 {
     public int[] twoSum(int[] numbers, int target) {
       
       int st = 0;
       int end = numbers.length-1;

       while(end>st){
         int sum = numbers[st]+numbers[end];
         if(sum==target){
             return new int[]{st + 1, end + 1};
         }

         if(sum>target){
            end--;
         }else{
            st++;
         } 
       }
        return new int[]{-1 ,-1};
    }
}
