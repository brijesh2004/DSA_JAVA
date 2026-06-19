public class Evaluate_Reverse_Polish_Notation{
     public int evalRPN(String[] tokens) {
        Stack<String>st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String str = tokens[i];
            if(str.equals("/")){
                int first = Integer.valueOf(st.pop());
                int second = Integer.valueOf(st.pop());
                st.add(String.valueOf(second/first));
            }else if(str.equals("*")){
                int first = Integer.valueOf(st.pop());
                int second = Integer.valueOf(st.pop());
                st.add(String.valueOf(second*first));
            }
            else if(str.equals("+")){
               int first = Integer.valueOf(st.pop());
                int second = Integer.valueOf(st.pop());
                st.add(String.valueOf(second+first));
            }
            else if(str.equals("-")){
              int first = Integer.valueOf(st.pop());
              int second = Integer.valueOf(st.pop());
             st.add(String.valueOf(second-first));
            }
            else{
                st.add(str);
            }
        }
       return Integer.valueOf(st.peek());
    }
}