class MyStack {
    Queue<Integer> temp;
    Queue<Integer> main;

    public MyStack() {
        temp = new LinkedList<>();
        main = new LinkedList<>();  
    }
    
    public void push(int x) {
        temp.add(x);

        while(!main.isEmpty()){
            temp.add(main.remove());
        }

        Queue<Integer> swap = temp;
        temp = main;
        main = swap; 
    }
    
    public int pop() {
        return main.remove();
    }
    
    public int top() {
        return main.peek();
    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */