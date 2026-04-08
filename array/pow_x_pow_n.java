public class pow_x_pow_n {
    private double solve(double x , int n){
        if(n==0) return 1;
        if(n==1) return x;
        int v = n/2;
        double val = solve(x , v);
        
        if(n%2==0){
            return val * val;
        }
        return x*val*val;
    }


    public double myPow(double x, int n) {
        
        int k = Math.abs(n);
        double ans =  solve(x , k);

        if(n<0) return 1.0/ans;
        return ans;
    }
}
