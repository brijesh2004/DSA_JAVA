public class Reverse_Word_In_A_String {
    public String reverseWords(String s) {
        String[] st = s.split(" ");
        System.out.println(st.length);
        String ans = "";
        for(int i=st.length-1;i>=0;i--){
            String k = st[i];
            if(k==" "|| k.length()==0) continue;
            if(i==st.length-1)
              ans+=k;
            else
              ans = ans+ " "+ k;
        }
       return ans;
    }
}
