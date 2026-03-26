class Permutation_in_string {
    public boolean checkInclusion(String s1, String s2) {
       int [] freq = new int[26];

       for(char ch: s1.toCharArray()){
        freq[ch-'a']++;
       }

       int end = 0;
       int st = 0;
       int count = s1.length();
       while(end<s2.length()){
        char ch = s2.charAt(end);
        if(freq[ch-'a']>0){
            count--;
        }
        freq[ch-'a']--;
        if(count==0) return true;
        if(end-st+1==s1.length()){
            char left = s2.charAt(st);
            if(freq[left-'a']>=0){
                count++;
            }
            freq[left-'a']++;
            st++;
        }
        end++;
       }
       return false;
    }
}