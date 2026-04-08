
public class sort_a_stack {
    private void moveToCorrectPos(int val , Stack<Integer>st){
        if(st.isEmpty()){
            st.push(val);
            return;
        }
        if(st.peek()>val){
            int v = st.peek();
            st.pop();
            moveToCorrectPos(val , st);
            st.push(v);
        }else{
            st.push(val);
        }
    }
    
    private void setToRightPosition(Stack<Integer>st){
        if(st.isEmpty()) return;
        
        int val = st.peek();
        st.pop();
        setToRightPosition(st);
        moveToCorrectPos(val , st);
    }
    
    
    public void sortStack(Stack<Integer> st) {
        // code here
        setToRightPosition(st);
        
    }
}
