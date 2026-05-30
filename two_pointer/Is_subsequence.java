package two_pointer;

public class Is_subsequence {
    public boolean isSubsequence(String s, String t) {
      int slen= 0;
      if(s.length()==0) return true;
      for(int i=0;i<t.length();i++){
        if(t.charAt(i)==s.charAt(slen)){
            slen++;
        }
        if(slen==s.length()) return true;
      }
      return false;
    }
}
