class Solution {
    private List<List<String>> ans=new ArrayList<>();

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (end >= start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void solve(int ind, String s, List<String> r) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(r));
            return;
        }

        String str = "";
        for(int i=ind;i<s.length();i++){
            str += s.charAt(i);
            if(isPalindrome(str)){
                r.add(str);
                solve(i+1 , s , r);
                r.remove(r.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<String>r = new ArrayList<>();
        solve(0 , s , r);
        return ans;
    }
}