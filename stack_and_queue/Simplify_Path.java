public class Simplify_Path{
    public String simplifyPath(String path) {
       String [] split = path.split("/");
       Stack<String>st = new Stack<>();

       for(int i=0;i<split.length;i++){
          String str = split[i];
          if(str.length()==0|| str.equals(".")){

          }
          else if(str.equals("..")){
             if(!st.isEmpty()){
                st.pop();
             }
          }else{
            st.add(str); 
          }
       }

       String ans = "";
       while(!st.isEmpty()){
          if(ans.length()!=0)
            ans = st.pop() + "/"+ans;
          else
            ans = st.pop();
       }
       return "/"+ans;


    }
}