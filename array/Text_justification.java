import java.util.ArrayList;
import java.util.List;

public class Text_justification {
    private String justifyText(List<String> str, int maxWidth, int len) {
        int gap = str.size() - 1;
        int remGap = maxWidth - len;

        String res = "";

        for (int i = 0; i < str.size(); i++) {
            String st = str.get(i);
            if (i != 0) {
                int gp = remGap / gap;
                if(remGap%gap!=0){
                    gp++;
                }
                if(gap==0){
                    gp = remGap;
                }
                remGap = remGap-gp;
                gap--;
                for (int j = 0; j < gp; j++) {
                    res += " ";
                }
            }
            res += st;
        }

        while(res.length()!=maxWidth){
            res+=" ";
        }
        return res;
    }

     private String justifyTextLast(List<String> str , int maxWidth) {
        

        String res = "";

        for (int i = 0; i < str.size(); i++) {
            String st = str.get(i);
            if (i != 0) {
               res+=" ";
            }
            res += st;
        }

        while(res.length()!=maxWidth){
            res+=" ";
        }
        return res;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> str = new ArrayList<>();
        int currLen = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            if (currLen + str.size() + len > maxWidth) {
                // justify the Text
                ans.add(justifyText(str, maxWidth, currLen));
                currLen = 0;
                str = new ArrayList<>();
            }
            // add to list
            str.add(words[i]);
            currLen += len;
        }
        ans.add(justifyTextLast(str , maxWidth));
        return ans;
    }
}
