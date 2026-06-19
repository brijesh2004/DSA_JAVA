public class Min_Stack{
    Stack<Integer>st = new Stack<>();
    Stack<Integer>minst = new Stack<>();

    public MinStack() {

    }

    public void push(int value) {
        st.add(value);
        // minHeap.add(value);
        // isRemoved.put(value , isRemoved.getOrDefault(value , 0)+1);

        if(minst.isEmpty()){
            minst.add(value);
        }else{
            if(minst.peek()>=value){
                minst.add(value);
            }
        }
    }

    public void pop() {
        // if(!st.isEmpty()){

        //     int v = st.pop();
        //     isRemoved.put(v , isRemoved.get(v)-1);
        // }

        if(st.peek().equals(minst.peek())){
            minst.pop();
        }
        st.pop();

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
     
        return minst.peek();
    }
}