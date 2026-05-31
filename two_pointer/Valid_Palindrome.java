package two_pointer;

public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int st = 0;
        int end = s.length()-1;

        while(end>st){
            char stChar = s.charAt(st);
            char endChar = s.charAt(end);
            
            char start = '#';
            char ended = '#';
            if(stChar>='0'&&stChar<='9'){
                start = stChar;
            }
            if(stChar>='a'&&stChar<='z'){
                start = stChar;
            }
            if(stChar>='A'&&stChar<='Z'){
                start = Character.toLowerCase(stChar);
            }


            if(endChar>='0'&&endChar<='9'){
                ended = endChar;
            }
            if(endChar>='a'&&endChar<='z'){
                ended = endChar;
            }
            if(endChar>='A'&&endChar<='Z'){
                ended = Character.toLowerCase(endChar);
            }
            if(start!='#'&&ended!='#'){
                if(start!=ended) return false;
                st++;
                end--;
            }
            else if(start=='#'){
                st++;
            }else{
                end--;
            }
        }
        return true;
    }
}
