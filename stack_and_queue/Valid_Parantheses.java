package stack_and_queue;

import java.util.Stack;

public class Valid_Parantheses {
     public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if(!st.isEmpty()) {
               char top =  st.pop();
               if(ch==')' && top=='('){
                
               }else if(ch=='}' && top=='{'){

               }else if(ch==']' && top=='['){

               }else return false;
            }
            else{
                return false;
            }
        }
        return st.isEmpty();
    }
}
