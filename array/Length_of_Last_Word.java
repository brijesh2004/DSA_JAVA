public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        String[] r = s.split(" ");
        int n = r.length;
        return r[n-1].length();
    }
}
