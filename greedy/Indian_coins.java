public class Indian_coins {
    int findMin(int n) {
        // code here
        int ans = 0;
        
        ans+=n/10;
        n=n%10;
        ans+=n/5;
        n=n%5;
        ans+=n/2;
        n=n%2;
        ans+=n;
        return ans;
    }
}
