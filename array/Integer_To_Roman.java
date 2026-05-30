public class Integer_To_Roman {
    public String intToRoman(int num) {
        // // write for 1 thousent
        // String ans = "";
        // int thousantCnt = num/1000;
        // num = num%1000;
        // while(thousantCnt>0){
        //     ans+="M";
        //     thousantCnt--;
        // }
        // if(num>=900){
        //     ans+="CM";
        //     num-=900;
        // }
        


        // // write for 500
        // int fiveHundredCnt = num/500;
        // num = num%500;
        // while(fiveHundredCnt>0){
        //     ans+="D";
        //     fiveHundredCnt--;
        // }
        // if(num>=400){
        //     ans+="CD";
        //      num-=400;
        // }

        // // write for 100
        // int hundredCnt = num/100;
        // num = num%100;
        // while(hundredCnt>0){
        //     ans+="C";
        //     hundredCnt--;
        // }
        // if(num>=90){
        //     ans+="XC";
        //      num-=90;
        // }

        // // write for 50
        // int fiftyCnt = num/50;
        // num = num%50;
        // while(fiftyCnt>0){
        //     ans+="L";
        //     fiftyCnt--;
        // }
        // if(num>=40){
        //     ans+="XL";
        //      num-=40;
        // }

        //  // write for 10
        // int tenCnt = num/10;
        // num = num%10;
        // while(tenCnt>0){
        //     ans+="X";
        //     tenCnt--;
        // }
        // if(num>=9){
        //     ans+="IX";
        //      num-=9;
        // }

        //  // write for 5
        // int fiveCnt = num/5;
        // num = num%5;
        // while(fiveCnt>0){
        //     ans+="V";
        //     fiveCnt--;
        // }
        // if(num>=4){
        //     ans+="IV"; 
        //     num-=4;
        // }

        // // write for 1
        // int oneCnt = num;
        // while(oneCnt>0){
        //     ans+="I";
        //     oneCnt--;
        // }
        // return ans;


        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }
}
