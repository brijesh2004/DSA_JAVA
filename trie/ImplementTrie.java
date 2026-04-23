package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementTrie {
    // Map<String , Boolean>mp ;
    // Map<Character , List<String>>st;
    // public Trie() {
    //     mp = new HashMap<>();
    //     st = new HashMap<>();

    // }
    
    // public void insert(String word) {
    //     mp.put(word , true);
    //     if(word.length()==0) return ;
    //     char a = word.charAt(0);
    //     if(st.containsKey(a)){
    //         st.get(a).add(word);
    //     }else{
    //         List<String> lis = new ArrayList<>();
    //         lis.add(word);
    //         st.put(a , lis);
    //     }
    // }
    
    // public boolean search(String word) {
    //     return mp.containsKey(word);
    // }
    
    // public boolean startsWith(String prefix) {
    //     // for(String key : mp.keySet()){
    //     //     if(key.startsWith(prefix)) return true;
    //     // }
    //     // return false;
    //     if(mp.containsKey(prefix)) return true;
    //     char ch = prefix.charAt(0);
    //     if(!st.containsKey(ch)) return false;
    //     for(String key: st.get(ch)){
    //         if(key.startsWith(prefix)) return true;
    //     }
    //     return false;

    // }




    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
        }

        private void insert(String word, int idx) {
            if (idx >= word.length()) return;
            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null) {
                nodes[i] = new Node();
            }

            if (idx == word.length()-1) nodes[i].isEnd = true;
            nodes[i].insert(word, idx+1);
        }

        private boolean search(String word, int idx) {
            if (idx >= word.length()) return false;
            Node node = nodes[word.charAt(idx) - 'a'];
            if (node == null) return false;
            if (idx == word.length() - 1 && node.isEnd) return true;

            return node.search(word, idx+1);

        }

        private boolean startsWith(String prefix, int idx) {
            if (idx >= prefix.length()) return false;
            Node node = nodes[prefix.charAt(idx) - 'a'];
            if (node == null) return false;
            if (idx == prefix.length() - 1) return true;

            return node.startsWith(prefix, idx+1);
        }
    }
}
