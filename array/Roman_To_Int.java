public class Roman_To_Int {
     public int intVal(char ch){
        switch(ch){
            case 'M' : return 1000;
            case 'D' : return 500;
            case 'C' : return 100;
            case 'L' : return 50;
            case 'X' : return 10;
            case 'V' : return 5;
        }
        return 1;
    }

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        int i = 0;
        while(i<n-1){
            int firstVal = intVal(s.charAt(i));
            i++;
            int secondVal = intVal(s.charAt(i));

            if(secondVal>firstVal){
                ans+=secondVal-firstVal;
                i++;
            }else{
                ans+=firstVal;
            }
        }

        if(i==n-1){
            ans+=intVal(s.charAt(n-1));
        }

        return ans;
    }
}
